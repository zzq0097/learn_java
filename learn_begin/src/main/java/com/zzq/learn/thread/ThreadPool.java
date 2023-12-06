package com.zzq.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final int j = i;
            Future<String> future = executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " " + j);
                    return "result:" + Thread.currentThread().getName() + " " + j;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
            futures.add(future);
        }


        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.MILLISECONDS,
                arrayBlockingQueue);

        executorService.submit(() -> {

        });

        CompletableFuture.runAsync(() -> {
        });

        CompletableFuture.supplyAsync(() -> {
            return "";
        });

        try {
            countDownLatch.await();
            System.out.println(countDownLatch.getCount());
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("所有线程执行完毕");
    }
}
