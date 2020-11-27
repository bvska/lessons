package com.ifmo.jjd.multithreading.lesson27;

import java.util.List;
import java.util.concurrent.*;

public class TasksExecutor {
    public static void main(String[] args) {
        // пулы потоков

        // [thread1, thread2]
        // tasks queue [task1, task2, task3, task4]

        // пул потоков можно создать:
        // * фиксированного размера
        // * пул размера от min до max
        // * пул для выполнения задач с указанным интервалом

        // interface
        // ThreadPoolExecutor
        ExecutorService fixedSizeService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int iVal = i;
            // принимает на вход Runnable, добавляет объект в очередь задач
            fixedSizeService.execute(()->{
                System.out.println(Thread.currentThread().getName() +
                        " выполнил задачу " + iVal);
            });
        }

        // fixedSizeService.shutdown(); // завершает текущие задачи
        // (те, что уже в очереди), но не принимает новые
        // после вызова метода shutdown пул нельзя использовать

        // не ждет выполнения текущих задач, возвращает список
        // с незавершенными задачами
        List<Runnable> shutdownTasks = fixedSizeService.shutdownNow();
        System.out.println(shutdownTasks);

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(()->{
            System.out.println("Task 1");
        });
        singleThread.execute(()->{
            System.out.println("Task 2");
        });
        singleThread.shutdown();


        // отложенное выполнение задачи
        ScheduledExecutorService scheduledService =
                Executors.newSingleThreadScheduledExecutor();
       // DelayedWorkQueue
        scheduledService.schedule(()->{
            System.out.println("Delayed Task - 15");
        }, 15, TimeUnit.SECONDS);
        scheduledService.schedule(()->{
            System.out.println("Delayed Task - 5");
        }, 5, TimeUnit.SECONDS);
        scheduledService.shutdown();

        // начало выполнения каждые 5 секунд
        ScheduledExecutorService everyFiveSecond =
                Executors.newSingleThreadScheduledExecutor();
        // Runnable
        everyFiveSecond.scheduleAtFixedRate(()->{
            System.out.println("AtFixedRate");
        }, 0, 5, TimeUnit.SECONDS);

        /*everyFiveSecond.scheduleAtFixedRate(()->{
            System.out.println("AtFixedRate - 2");
        }, 0, 7, TimeUnit.SECONDS);*/

        // указанный интервал отсчитывается от момента завершения задачи
        ScheduledExecutorService everySecond =
                Executors.newSingleThreadScheduledExecutor();
        everySecond.scheduleWithFixedDelay(()->{
            System.out.println("WithFixedDelay");
        }, 0, 1, TimeUnit.SECONDS);

    }
}
