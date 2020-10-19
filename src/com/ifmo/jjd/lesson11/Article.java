package com.ifmo.jjd.lesson11;

import java.time.LocalDate;



public class Article {
    private final String title;
    private String text;
    private final LocalDate created;

    public Article(String title) {
        this.title = title;
        created = LocalDate.now();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDate getCreated() {
        return created;
    }
}
