package com.ifmo.jjd.lesson9;


import java.util.Objects;

public class ObjectMethods {
    public static void main(String[] args) {
        // Класс Object является родительским для всех классов в java
        // Классы наследуют от Object следующие методы:
        // getClass() - возвращает ссылку на класс объекта
        // wait / notify / notifyAll используются в многопоточном программировании
        // hashCode() - возвращает хэш-код объекта (типа int)
        // equals(Object obj) — возвращает true, если объекты одинаковы, по умолчанию выполняет сравнение по ссылке ==;
        // toString() - возвращает строковое представление объекта

        Object obj = new Object();
        // Object можно использовать как общий тип данных, в таком случае
        // объекту будут доступны только методы Object
        Object author = new Author("Иван", "Петров");

        Author ivan = new Author("Иван", "Петров");
        Author anna = new Author("Анна", "Гришкова");

        ColouringBook cars = new ColouringBook("Машинки", 23, 15);
        cars.setAuthor(ivan);

        ColouringBook robots = new ColouringBook("Роботы", 38, 19);
        robots.setAuthor(ivan);

        ColouringBook flowers = new ColouringBook("Цветы", 12, 10);
        flowers.setAuthor(anna);

        // toString() - возвращает строковое представление объекта
        System.out.println(ivan.toString());
        System.out.println(flowers.toString());

        // equals() и hashCode() используются для сравнения объектов, при добавлении (извлечении, удалении) объектов в коллекции и мапы
        //

        Author author1 = new Author("Михаил", "Петров");
        Author author2 = new Author("Михаил", "Петров");

        // == сравнивает ссылки на объект
        System.out.println(author1 == author2); // false
        // метод equals() используется для сравнения объектов equals() по умолчанию сравнивает ссылки на объект
        System.out.println(author1.equals(author2));

        // Правила переопределения equals и hashCode:
        // equals()
        // 1. объект всегда равен самому себе (рефлективность)
        // 2. если a.equals(b) то и b.equals(a) (симметричность)
        // 3. если a.equals(b), b.equals(c) то и a.equals(c) (транзитивность)
        // 4. сколько бы раз не вызывался equals без изменения состояния
        // объекта, результат должен оставаться неизменным (консистентность)
        // hashCode()
        // 1. если объекты равны по equals, то hashCode должен вернуть
        // одинаковое значение для обоих объектов
        // 2. если объекты не равны по equals, то hashCode может вернуть
        // одинаковое значение для обоих объектов
        // 3. если состояние объекта не меняется, hashCode должен возвращать одинаковый результат
        System.out.println(author1.hashCode());
        System.out.println(author2.hashCode());

        ColouringBook colouring1 = new ColouringBook("Роботы", 56, 19);
        colouring1.setAuthor(ivan);

        ColouringBook colouring2 = new ColouringBook("Роботы", 38, 19);
        colouring2.setAuthor(anna);

        System.out.println(colouring1.equals(colouring2));

        // clone()
        // модификатор доступа метода - protected
        // метод возвращает Object
        // при переопределении метода clone вызов super.clone() - обязывает метод выбрасывать CloneNotSupportedException
        // super.clone() не создает объектов
        // если не использовать super.clone(), то метод не должен выбрасывать CloneNotSupportedException,
        // но нужно будет написать свою реализацию (создание нового объекта, исходя необходимой логики клонирования)

        // ColouringBook cloneColouring = colouring1; - создание ссылки на существующий объект

        ColouringBook cloneColouring = colouring1.clone();
        System.out.println(cloneColouring == colouring1);

        // instanceof проверяет принадлежность объекта к какому то типу

        // класс Objects - набор статических методов для работы с объектами
        // среди них: различные проверки на null, сравнение объектов, приведение объекта к строке и тд
        // Например,
        // Objects.hash(object) вернет hashCode объекта
        // Objects.requireNonNull(null, "Not NULL"); / Objects.requireNonNull(null); - проверка на null и генерация исключения


    }
}
