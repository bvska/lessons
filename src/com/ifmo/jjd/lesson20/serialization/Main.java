package com.ifmo.jjd.lesson20.serialization;

import java.io.*;

public class Main  {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);

        System.out.println(pupil1);
        System.out.println(pupil2);
        System.out.println(director);

        File file = new File("school.bin");
        objectToFile(file, pupil1);
        objectToFile(file, pupil2);
        // запись pupil2

        Pupil pupilFromFile1 = (Pupil) objectFromFile(file);
        System.out.println(pupilFromFile1);
        System.out.println(pupil1.equals(pupilFromFile1));

        Pupil pupilFromFile2 = (Pupil) objectFromFile(file);
        System.out.println(pupilFromFile2);
        System.out.println(pupil2.equals(pupilFromFile2));


        // сериализация - объект, как последовательность байт
        // ObjectOutputStream
        // десериализация - последовательность байт в объект (Object)
        // ObjectInputStream
        // ObjectOutputStream и ObjectInputStream - декораторы, соответственно
        // в конструктор ObjectInputStream мы должны передать InputStream
        // в конструктор ObjectOutputStream мы должны передать OutputStream

        // объект -> последовательность байт -> файл
        // файл -> последовательность байт -> объект

        // Класс должен реализовывать:
        // интерфейс java.io.Serializable (интерфейс - маркер)
        // (по умолчанию сериализуются все поля,
        // есть возможность исключить поля из этого процесса)
        // если имплементация Serializable будет у дочернего класса, то полученные
        // от родителя свойства не участвуют в сериализации
        // при десериализации мы получим значения по молчанию по этим полям
        // если имплементация Serializable будет у родителя, то все его потомки
        // будут Serializable классами
        // свойства отмеченные transient не участвуют в сериализации

        // или интерфейс java.io.Externalizable
        // (по умолчанию не сериализуется ни одно поле,
        // есть возможность указать, какие поля должны участвовать в сериализации)




    }

    private static void objectToFile(File file, Object object){
        try (FileOutputStream fileStream = new FileOutputStream(file, true);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileStream)){
            objectOutput.writeObject(object);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException io) {
            System.out.println("IOException");
        }
    }

    private static Object objectFromFile(File file) {
        Object o = null;
        try (FileInputStream fileInput = new FileInputStream(file); // чтение из файла
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)){ // десериализация

            o = objectInput.readObject(); // ClassNotFoundException

        } catch (FileNotFoundException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return o;
    }


}

class Some<T> {
    public void write(T o){

    }

    public T read(){
        return null;
    }
}
