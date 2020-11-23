package com.ifmo.jjd.multithreading.lesson25.sync;

public class SomeAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }
    public void upBalance(int count) {
        balance += count;
    }
}
