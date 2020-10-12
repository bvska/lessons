package com.ifmo.jjd.lesson9;


public class App {
    public static void main(String[] args) {
        Author ivan = new Author("Иван", "Петров");
        Author anna = new Author("Анна", "Гришкова");

        ColouringBook cars = new ColouringBook("Машинки", 23, 15);
        cars.setAuthor(ivan);

        ColouringBook robots = new ColouringBook("Роботы", 38, 19);
        robots.setAuthor(ivan);

        ColouringBook flowers = new ColouringBook("Цветы", 12, 10);
        flowers.setAuthor(anna);

        // Все классы наследуются от класса Object
        Object obj = new Object();
        Object author = new Author("Иван", "Петров");

        // toString()
        System.out.println(ivan.toString());
        System.out.println(flowers.toString());

        // equals() и hashCode() используются для сравнения объектов
        // Objects.hash(object) вернет hashCode объекта

        Author author1 = new Author("Михаил", "Петров");
        Author author2 = new Author("Михаил", "Петров");
        // == сравнивает ссылки на объект
        System.out.println(author1 == author2); // false
        // метод equals() используется для сравнения объектов
        // equals() по умолчанию сравнивает ссылки на объект
        System.out.println(author1.equals(author2)); // true
        // instanceof проверяет принадлежность объекта к какому то типу

        // equals()
        // 1. объект всегда равен самому себе (рефлективность)
        // 2. если a.equals(b) то и b.equals(a) (симметричность)
        // 3. если a.equals(b), b.equals(c) то и a.equals(c) (транзитивность)
        // 4. сколько бы раз не вызывался equals без изменения состояния
        // объекта, результат должен оставаться неизменным (консистентность)
        // hashCode()
        // 1. если объекты равны по equals, то hashCode должен вернуть
        // одиноковое значение для обоих объектов
        // 2. если объекты не равны по equals, то hashCode может вернуть
        // одиноковое значение для обоих объектов
        // 3. если состояние объекта не меняется, hashCode должен ввозвращать
        // одинаковый результат
        System.out.println(author1.hashCode());
        System.out.println(author2.hashCode());

        ColouringBook colouring1 = new ColouringBook("Роботы", 56, 19);
        colouring1.setAuthor(ivan);

        ColouringBook colouring2 = new ColouringBook("Роботы", 38, 19);
        colouring2.setAuthor(anna);

        System.out.println(colouring1.equals(colouring2));

        // clone()
        // модификатор доступа - protected
        // возвращает Object
        // super.clone() - не создает копии объектов
        // super.clone() обязывает метод выбрасывать CloneNotSupportedException
        // если не использовать super.clone(), то метод не должен выбрасывать CloneNotSupportedException,
        // но нужно будет написать свою реализацию (создание нового объекта)

        // ColouringBook cloneColouring = colouring1;

        ColouringBook cloneColouring = colouring1.clone();
        System.out.println(cloneColouring == colouring1);

        // класс Objects - набор статических методов для работы с объектами
        // Objects.requireNonNull(null, "Not NULL");
        // Objects.requireNonNull(null);

    }
}
