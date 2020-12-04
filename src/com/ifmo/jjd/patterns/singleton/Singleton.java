package com.ifmo.jjd.patterns.singleton;

import java.util.concurrent.ThreadPoolExecutor;

public class Singleton {
    private static Singleton instance;
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private Singleton(int num){
        this.num = num;
    }

    public static Singleton getInstance(int num){
        if (instance == null) {
            instance = new Singleton(num);
        }
        return instance;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}


    public static synchronized ThreadSafeSingleton getInstance(){
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}



