package com.zzq.learn.ago.learn.thread;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.vavr.control.Try;

import java.util.concurrent.*;

public class RunTest3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        for (int i = 0; i < 1000; i++) {
            final int j = i;
            CompletableFuture.runAsync(() -> {
                Try.run(() -> {
                    Thread.sleep(RandomUtil.randomInt(1000, 3000));
                });
                System.out.println(StrUtil.format("thread:{} --- task:{}",
                        Thread.currentThread().getName(), j));
            }, threadPoolExecutor);
        }

    }
}
