package com.zzq.learn.ago.learn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("hee");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("woo");
        return "";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Long start = System.currentTimeMillis();
        System.out.println(start);
//        test();
        for (Future<String> stringFuture : test()) {
            System.out.println(stringFuture.get());
        }

        Long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end - start);
    }

    public static List<Future<String>> test() throws InterruptedException {
        ExecutorService poolExecutor = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(poolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Thread.currentThread().getName();
            }));
        }
        poolExecutor.shutdown();
        return list;
    }

    public static List<Future<String>> test2() {
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                Thread.sleep(1000);
                return Thread.currentThread().getName();
            });
            new Thread(futureTask).start();
            list.add(futureTask);
        }
        return list;
    }
}
