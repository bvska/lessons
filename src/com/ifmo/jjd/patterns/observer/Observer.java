package com.ifmo.jjd.patterns.observer;

// данный интерфейс должны имплементировать все наблюдатели
public interface Observer {
    void greenEvent(int code);
    void yellowEvent(int code);
    void redEvent(int code);
}
