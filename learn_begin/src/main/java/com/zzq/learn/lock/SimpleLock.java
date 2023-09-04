package com.zzq.learn.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SimpleLock {
    private final static Logger logger = LoggerFactory.getLogger(SimpleLock.class);

    private static final Lock lock = new ReentrantLock();

    private static int num = 10;


    public void parallelSub() {
        logger.info("进入方法");
        try {
            Thread.sleep(1000);
            num--;
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("执行完毕");
    }

    public synchronized void safeParallelSub1() {
        logger.info("进入方法");
        try {
            Thread.sleep(1000);
            num--;
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("执行完毕");
    }

    public void safeParallelSub2() {
        logger.info("进入方法");
        lock.lock();
        logger.info("获取到了锁");
        try {
            Thread.sleep(1000);
            logger.info("开始执行减一");
            num--;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("开始释放锁");
            lock.unlock();
        }
        logger.info("执行完毕");
    }

    public static void main(String[] args) {
        final int n = num;
        ExecutorService pool = Executors.newFixedThreadPool(n);
        SimpleLock simpleLock = new SimpleLock();
        long now = System.currentTimeMillis();
        CompletableFuture<Void>[] completableFutures = new CompletableFuture[n];
        for (int i = 0; i < n; i++) {
//            // 不加锁
//            completableFutures[i] = CompletableFuture.runAsync(simpleLock::parallelSub, pool);
//            // synchronized
//            completableFutures[i] = CompletableFuture.runAsync(simpleLock::safeParallelSub1, pool);
            // lock
            completableFutures[i] = CompletableFuture.runAsync(simpleLock::safeParallelSub2, pool);
        }
        CompletableFuture.allOf(completableFutures).join();
        logger.info("执行用时: " + (System.currentTimeMillis() - now));
        logger.info("结果: " + num);
        pool.shutdown();
    }
}
