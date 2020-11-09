package com.ifmo.jjd.lesson19;

import lesson1.FirstLesson;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;

/**
 * Класс IOLesson
 * @author Ifmo
 * @version 1.1
 * */
public class IOLesson {
    /**
     * Описание поля
     * @see IOLesson#setData(String)
     * */
    private String data;

    /**
     * Конструктор ...
     * @param data описание параметр
     * */
    public IOLesson(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static void main(String[] args) throws IOException {

        // пакеты IO / NIO
        // IO предоставляет возможность передавать данные
        // в виде последовательности byte или
        // последовательности char

        File file = new File("somefile.txt");


        try {
            file.createNewFile(); // создание файла
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.exists()); // существует или нет
        // является ли file директорией
        System.out.println(file.isDirectory());
        // является ли file файлом
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());

        // список файлов в директории
        File[] files = new File("sources").listFiles();

        File lessonFile = new File("sources/lesson19.txt");
        // 1. если программа передает данные, используем наследников
        // OutputStream
        // 2. если программа получает данные, используем наследников
        // InputStream

        try {
            writeToFile(lessonFile, "строка для записи", false);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // при написании собственных декораторов для io классы-декораторы должны
        // наследоваться от FilterOutputStream FilterInputStream

        try (SomeIODecorator someIODecorator = new SomeIODecorator(
                new BufferedOutputStream(
                        new FileOutputStream(file)))){
            // сначала данные будут обработаны SomeIODecorator,
            // потом будет вызван метод write BufferedOutputStream,
            // он начнет накапливать данные,
            // когда буфер заполнится, будет вызван метод write FileOutputStream,
            // данные будут переданы в файл file
            someIODecorator.write("dds".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Метод записи в файл
     *
     * @param file файл для записи
     * @param data строка для записи
     * @param append флаг
     *               если значение true, запись в конец файла
     *               если значение false, запись в начало файла
     *
     * @throws IOException файл не найден (не удалось создать файл),
     *                      проблема во время записи
     */
    private static void writeToFile(
            File file, String data, boolean append) throws IOException {
        // try-with-sources
        // когда выполнение блока try завершится (с исключением или без него)
        // у объектов, созданных в () будет вызван метод close()
        // Для создания объектов внутри () необходима имплементация
        // интерфейса AutoCloseable и реализация метода close()
        try (FileOutputStream outputStream =
                     new FileOutputStream(file, append)){
            // преобразование строки в массив байт
            byte[] bytes = data.getBytes();
            outputStream.write(bytes); // запись массива байт
        }
    }

    // программа -> буфер(BufferedOutputStream) -> файл(FileOutputStream)
    private static void writeWithBuffer(File file) throws IOException {
        // new FileOutputStream(file) -> append - false, запись в начало файла
        try (FileOutputStream outputStream = new FileOutputStream(file);
             // BufferedOutputStream(OutputStream out, int size), где size -
             // размер буфера. По умолчанию - 8192
             BufferedOutputStream buffer = new BufferedOutputStream(outputStream)){
            // BufferedOutputStream является декоратором по отношению к FileOutputStream
            for (int i = 0; i < 100_000; i++) {
                buffer.write((i + " ").getBytes());
            }
        }
    }

    /**
     * Метод чтения из файла
     *
     * @param file файл, содержимое которого нужно прочитать
     *
     * @return строка, прочитанная из файла
     *
     * @throws IOException файл не найден, проблема во время чтения
     * */
    private static String readFromFile(File file) throws IOException{
        String res = null;
        try (
                FileInputStream fileStream = new FileInputStream(file);
                // BufferedInputStream buffer = new BufferedInputStream(fileStream);
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                ) {

            byte[] bytes = new byte[3];
            int data;
            // read возвращает количество прочитанных байт или -1, если нечего читать
            while ((data = fileStream.read(bytes)) != -1) {
                byteArray.write(bytes, 0, data);
            }

            res = new String(byteArray.toByteArray());
        }
        return res;
    }


    // img -> byte[] ---передача--- byte[] -> img
    public static boolean byteArrayToImg(File file, byte[] bytes) throws IOException {
       ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
       BufferedImage image = ImageIO.read(inputStream);
       return ImageIO.write(image, "jpg", file);

    }

    public static byte[] imgToByteArray(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        return outputStream.toByteArray();
    }

}

class SomeIODecorator extends FilterOutputStream {

    public SomeIODecorator(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        // шифрование xor ^
        out.write(b);
    }
}

class SomeInputDecorator extends FilterInputStream {

    protected SomeInputDecorator(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        // расшифровка полученных данных
        return in.read(b); // read вернет количество прочитанных байт
    }
}

// "hello" -> зашифровали -> записали в файл ->
// -> прочитали из файла -> расшифровали -> "hello"