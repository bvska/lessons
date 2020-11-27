package com.ifmo.jjd.multithreading.lesson27;

import java.util.Collection;
import java.util.List;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class TestExecutor {
    public static void main(String[] args) {
        // public interface Lock

        // Semaphore
        // Exchanger
        // CountDownLatch


//        int corePoolSize, первоначальное (min) количество потоков
//        int maximumPoolSize, максимальное количество потоков
//        long keepAliveTime, сколько поток может простаивать
//        TimeUnit unit, прежде чем будет удален из пула
//        BlockingQueue<Runnable> workQueue очередь задач

        ExecutorService service = new ThreadPoolExecutor(
                2,
                5,
                200,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );
        service.execute(()->{
            System.out.println("Task 1");
        });
        service.execute(()->{
            System.out.println("Task 2");
        });
        service.shutdown();
    }
}

class BetterExecutor extends ThreadPoolExecutor {

    public BetterExecutor(int corePoolSize, int maximumPoolSize,
                          long keepAliveTime, TimeUnit unit) {
        super(corePoolSize, maximumPoolSize,
                keepAliveTime, unit,
                new LinkedBlockingQueue<>());
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("Перед выполнением задачи");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("После выполнения задачи");
    }
}

class SuperExecutor implements ExecutorService{

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }
}