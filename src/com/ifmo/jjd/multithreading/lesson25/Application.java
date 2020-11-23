package com.ifmo.jjd.multithreading.lesson25;

import com.ifmo.jjd.multithreading.lesson25.sync.IncrementTask;
import com.ifmo.jjd.multithreading.lesson25.sync.SomeAccount;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        SomeAccount account = new SomeAccount();

        ArrayList<IncrementTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new IncrementTask(account));
        }
    }
}
