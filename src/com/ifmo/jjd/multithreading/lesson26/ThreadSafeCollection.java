package com.ifmo.jjd.multithreading.lesson26;

import com.ifmo.jjd.multithreading.lesson26.blocking.ReadSignals;
import com.ifmo.jjd.multithreading.lesson26.blocking.Signal;
import com.ifmo.jjd.multithreading.lesson26.blocking.Task;
import com.ifmo.jjd.multithreading.lesson26.blocking.WriteSignals;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class ThreadSafeCollection {
    public static void main(String[] args) {
        // Vector, HashTable, Stack

        // однопоточные коллекции и мапы в многопоточные
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        LinkedBlockingQueue<String> strings = new  LinkedBlockingQueue<>();
        LinkedBlockingQueue<Integer> integers = new  LinkedBlockingQueue<>(23);

        ArrayBlockingQueue<Signal> signals = new ArrayBlockingQueue<>(20, true);
        new Thread(new WriteSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
        new Thread(new WriteSignals(signals)).start();

        // если объекты будут добавлены в DelayQueue, то класс экземплярами
        // которого они являются должен реализовать интерфейс Delayed


        DelayQueue<Task> tasks = new DelayQueue<>();

        tasks.put(new Task(LocalDateTime.now().minusDays(1), ()->{
            System.out.println("Old");
        }));
        tasks.put(new Task(LocalDateTime.now().plusSeconds(10), ()->{
            System.out.println("Now");
        }));
        tasks.put(new Task(LocalDateTime.now().plusMinutes(2), ()->{
            System.out.println("Future");
        }));

        while (true){
            try {
                Task task = tasks.take();
                Runnable action = task.getAction();
                new Thread(action).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }






    }
}
