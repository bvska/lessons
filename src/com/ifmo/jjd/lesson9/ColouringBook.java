package com.ifmo.jjd.lesson9;

public class ColouringBook extends Book{

    private int picsCount;

    public ColouringBook(String title, int pageCount, int picsCount) {
        super(title, pageCount);
        this.picsCount = picsCount;
    }

    public int getPicsCount() {
        return picsCount;
    }
}
