package com.ifmo.jjd.multithreading.lesson27;

import com.ifmo.jjd.multithreading.lesson26.blocking.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        // [thread1, thread2]
        // [task1, task2, task3]
        ExecutorService signalService = Executors.newFixedThreadPool(3);
        Callable<Signal> signalGenerator = new SignalGenerator();

        ArrayList<Future<Signal>> signalContainers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // передает задачу в очередь
            Future<Signal> container = signalService.submit(signalGenerator);
            signalContainers.add(container);
        }

        /*for (Future<Signal> container: signalContainers){
            System.out.println("Waiting future...");
            try {
                System.out.println("Signal: " + container.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        signalService.shutdown();*/

        for (Future<Signal> container: signalContainers){
            System.out.println("Waiting future...");
            try {
                System.out.println("Signal: " +
                        container.get((long)(Math.random()*1000), TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("не смог дождаться появления сигнала в контейнере");
            }
        }
        signalService.shutdown();

        List<Callable<Signal>> tasksList = new ArrayList<>();
        Callable<Signal> callable = ()->{
            Thread.sleep((long) (Math.random() * 3000));
            Signal signal = Signal.getSignal();
            System.out.println("Новый Сигнал " + signal);
            return signal;
        };
        tasksList.add(callable);
        tasksList.add(callable);
        tasksList.add(callable);
        tasksList.add(callable);

        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            List<Future<Signal>> futureList = service.invokeAll(tasksList);
            service.shutdown();

            for (Future<Signal> container: futureList) {
                System.out.println("SIGNAL: " + container.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        // [thread1, thread2, thread3]
        // [
        // task1 -> []
        // task2 -> []
        // task3 -> []
        // task4 -> []
        // task5 -> []
        // ]


    }
}

class SignalGenerator implements Callable<Signal> {

    @Override // инструкции потока (альтернатива Runnable)
    public Signal call() throws Exception {
        Thread.sleep((long) (Math.random() * 3000));
        Signal signal = Signal.getSignal();
        System.out.println("Сгенерирован объект " + signal);
        return signal;
    }
}
