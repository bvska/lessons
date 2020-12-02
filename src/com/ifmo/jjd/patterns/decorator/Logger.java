package com.ifmo.jjd.patterns.decorator;

// класс с основным функционалом
public class Logger implements ILogger { // вывод данных в консоль
    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
