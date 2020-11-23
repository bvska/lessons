package com.ifmo.jjd.multithreading.lesson25.sync;



public class IncrementTask extends Thread{
    private final SomeAccount account;

    public IncrementTask(SomeAccount account){
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.upBalance(10);
    }
}
