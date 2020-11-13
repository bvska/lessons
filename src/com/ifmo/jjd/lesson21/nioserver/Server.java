package com.ifmo.jjd.lesson21.nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        // запускаем один поток для обработки всех соединений
        new Thread(new NioThread()).start();
    }

    private class NioThread extends Worker{
        private static final int BUF_SIZE = 1024;

        private ByteBuffer byteBuffer;
        private ServerSocketChannel serverChannel;
        private Selector selector;

        @Override
        protected void init() throws IOException {
            byteBuffer = ByteBuffer.allocate(BUF_SIZE);

            selector = Selector.open();

            serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(8090));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, serverChannel.validOps());
        }

        @Override
        protected void loop() throws IOException {
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                if (key.isAcceptable()){
                    SocketChannel channel = serverChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Client connected " + channel.getRemoteAddress());
                } else if (key.isReadable()) {
                    System.out.println("читаем входящие данные...");
                    readData((SocketChannel)key.channel());
                } else if (key.isValid() && key.isWritable()){
                    System.out.println("запись данных в канал...");
                    writeData((SocketChannel)key.channel(), key);
                }
                iterator.remove();
            }

        }

        @Override
        protected void stop() throws IOException {
            serverChannel.close();
            selector.close();
        }

        private void readData(SocketChannel channel){
            byteBuffer.clear();

            try {
                int read = channel.read(byteBuffer);
                if(read != -1) {
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), StandardCharsets.UTF_8));
                } else {
                    System.out.println("client disconnected " + channel.getRemoteAddress());
                    channel.close();
                }

                byteBuffer.flip();

                Set<SelectionKey> keys = selector.keys();
                for (SelectionKey key: keys){
                    if ((key.channel().validOps() & SelectionKey.OP_WRITE) > 0){
                        key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                    }
                }

            } catch (IOException e) {
                System.out.println("client disconnected ");
                byteBuffer.clear();
                try {
                    channel.close();
                } catch (IOException e1) {
//                    e1.printStackTrace();
                }
            }
        }

        private void writeData(SocketChannel channel, SelectionKey key) throws IOException {
            channel.write(byteBuffer);
            byteBuffer.rewind();
            key.interestOps(key.interestOps() &~ SelectionKey.OP_WRITE);
        }
    }
}