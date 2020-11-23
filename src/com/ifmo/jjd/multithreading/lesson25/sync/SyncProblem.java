package com.ifmo.jjd.multithreading.lesson25.sync;

public class SyncProblem {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " запущен");
            synchronized (object1){
                synchronized (object2){
                    System.out.println("thread1 -> object2 и object1");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " запущен");
            synchronized (object1){
                synchronized (object2){
                    System.out.println("thread2 -> object2 и object1");
                }
            }
        });
        // thread1 -> object1 -> object2
        // thread2 -> object1 -> object2
        thread1.start();
        thread2.start();
    }
}
