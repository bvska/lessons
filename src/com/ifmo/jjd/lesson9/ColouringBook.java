package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class ColouringBook extends Book{

    private int picsCount;

    public ColouringBook(String title, int pageCount, int picsCount) {
        super(title, pageCount);
        this.picsCount = picsCount;
    }

    public int getPicsCount() {
        return picsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColouringBook)) return false;
        ColouringBook that = (ColouringBook) o;
        return picsCount == that.picsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(picsCount);
    }

    @Override
    public ColouringBook clone(){
        ColouringBook book = new ColouringBook(
                this.getTitle(), this.getPageCount(), picsCount);
        // book.setAuthor(this.getAuthor()); сслыка на author
        book.setAuthor(new Author( // создание нового экземпляра Author
                this.getAuthor().getName(),
                this.getAuthor().getSurname()
                ));
        return book;
    }

    @Override
    public String toString() {
        return "ColouringBook{" +
                "picsCount=" + picsCount + '\'' +
                "pageCount=" + getPageCount() + '\'' +
                "title=" + getTitle() + '\'' +
                "author=" + getAuthor() + // // если toString не переопределен в классе Author, получим: имя класса + hashCode
                '}';
    }
}
