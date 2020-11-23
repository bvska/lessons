package com.ifmo.jjd.multithreading.lesson25.waitnotify;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>(6);

    // не более 6 книг
    public synchronized void putBook(Book book) throws InterruptedException {
        while (books.size() > 5) {
            System.out.println("put поток уходит в ожидание...");
            wait();
            // 1. произвольное пробуждение
            // 2. если к моменту пробуждения условие при котором поток
            // должен ждать все еще выполняется
        }
        books.add(book);
        System.out.println("Книга добавлена, всего книг: " + books.size());
        notify();
    }

    public synchronized Book getBook() throws InterruptedException {
        while (books.size() == 0){
            System.out.println("get уходит в ожидание");
            wait();
        }
        Book book = books.remove(0);
        System.out.println("Удалена книга, всего книг: " + books.size());
        notify();
        return book;
    }
}
// wait / notify должны быть вызваны либо в synchronized блоке,
// либо в synchronized методе (иначе будет IllegalMonitorStateException)
// putThreads  (должны ждать, если в хранилище 6 объектов ) ->
// -> library: wait set [put1, put2] ->
// -> getThreads (если объектов в хранилище нет, поток ждет, пока они появятся)

// put1 -> library.wait()
// приостанавливает работу потока до тех пор, пока поток не будет разбужен,
// например, вызовом метода notify

// put2 -> library.wait()

// get1 -> library.notify()
// get2 -> library.notifyAll()
// put3 -> library.wait(1000) проснулся сам, тк не был разбужен методом notify
// и прошло указанное в методе wait количество млс
// put4 -> library.wait() - проснулся сам, тк произошло случайное пробуждение потока

class Book{}
