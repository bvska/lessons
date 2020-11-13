package com.ifmo.jjd.lesson21;

import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOBuffer {
    public static void main(String[] args) {

        // пакет nio (new io / non-blocking io) предназначен для работы с вводом и выводом
        // * неблокирующий
        // * асинхронный
        // * буфер-ориентированный



        // Path, Files
        // набор классов Channel, набор классов Buffer, селекторы


        // Каналы: программа буфер ======= файл
        // можно использовать и для записи и для чтения
        // события в канале могут происходить асинхронно
        // каналы всегда читают из буфера и пишут в буфер
        // FileChannel - для работы с файлами
        // SocketChannel - клиентский сокет, используется для подключения к серверу
        // и передачи данных по TCP протоколу
        // DatagramChannel - клиентский сокет, используется для подключения к серверу
        // и передачи данных по UDP протоколу
        // ServerSocketChannel - используется на сервере

        // Буферы:
        // ByteBuffer
        // CharBuffer
        // DoubleBuffer / FloatBuffer
        // ShortBuffer / IntBuffer / LongBuffer

        // свойства буферов:
        // capacity - емкость (задается при создании буфера и не меняется)
        // position - текущая позиция в буфере (изначально равна 0)
        // limit - указатель, до какого значения можно читать / писать данные
        // (изначально равен capacity)

        // assert используются только при разработке,
        // чтобы они работали их нужно включить:
        // Edit Configuration -> VM options: -ea


        ByteBuffer buffer = ByteBuffer.allocate(16);
        System.out.println(buffer.position()); // возвращает позицию
        System.out.println(buffer.capacity()); // возвращает емкость
        System.out.println(buffer.limit()); // возвращает значение limit
        System.out.println(buffer.remaining()); // возвращает разницу между position и limit
        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16; // разница между position и limit

        // put - запись в буфер
        // Увеличивает позицию на 4.
        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 8.
        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        // Подготовка буфера для чтения:
        // устанавливает лимит на место позиции, сбрасывает позицию в 0 (для чтения из буфера)
        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        // Увеличивает позицию на 8.
        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        // Сбрасывает позицию в 0 (limit остается на прежнем месте - для повторного чтения)
        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        assert anInt == buffer.getInt();
        // Увеличивает позицию на 8.
        assert aDouble == buffer.getDouble();

        // Сбрасывает позицию в 0, ставит лимит, равный емкости буфера (для записи в буфер)
        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        // для установки значений вручную buffer.position(2);

        // копирует все непрочитанные данные в начало буфера,
        // установит limit равной емкости буфера
        // Буфер готов для записи после непрочитанных данных
        // buffer.compact();

    }
}