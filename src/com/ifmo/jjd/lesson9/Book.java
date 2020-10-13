package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class Book {
    protected String title;
    protected int pageCount;
    protected Author author;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        Objects.requireNonNull(author, "author не должен быть null");
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }





    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author + // если toString не переопределен в классе Author, получим: имя класса + hashCode
                '}';
    }
}
