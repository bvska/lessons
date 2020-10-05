package com.ifmo.jjd.lesson6;

// com.ifmo.jjd.lesson6.Application
public class Application {
    public static void main(String[] args) {
        // создание объекта
        // тип_данных имя_переменной = new конструктор();
        // создание объекта типа ColouringBook
        ColouringBook dogs = new ColouringBook();
        ColouringBook flowers = new ColouringBook();
        // обращение к свойству
        // dogs.title = "Собаки";
        // при таком подходе в свойсво можно записать все что угодно
        // и это может навредить программе, например,
        // dogs.title = ""; dogs.title = null;
        // поэтому лучше органичить доступ к свойству используя
        // модификаторы
        dogs.setTitle("Собаки");
        flowers.setTitle("Цветы");

        String dogsTitle = dogs.getTitle();
        System.out.println(dogsTitle);
        System.out.println(flowers.getTitle());

        Author ivan = new Author("Иван");
        // ivan.setName("Иван");
        ivan.setSurname("Петров");

        System.out.println(ivan.getFullName());

        dogs.setAuthor(ivan);
        // dogs.getAuthor() -> объект Author
        System.out.println(dogs.getAuthor().getFullName());

        System.out.println(dogs);

        ColouringShelf shelf = new ColouringShelf(11, "белый");
        System.out.println(shelf);

        shelf.addColouring(dogs);
        shelf.addColouring(flowers);

        shelf.addColouring(dogs, flowers);

        System.out.println(shelf.getBooksInfo());


    }
}
