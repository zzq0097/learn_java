package com.zzq.learn.ago.learn.thread;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class RunTest {
    static int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
    static int maxPoolSize = 50;
    static long keepAliveTime = 30;
    static TimeUnit unit = TimeUnit.MINUTES;
    static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
    static RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            corePoolSize, maxPoolSize,
            keepAliveTime, unit
            , workQueue);

    static int size = 5;

    public static void main(String[] args) {
        int taskSize = 100;
        AtomicInteger undoneCount = new AtomicInteger(taskSize);
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(taskSize);
        for (int i = 0; i < taskSize; i++) {
            final int j = i;
            blockingQueue.offer(() -> {
                System.out.println(StrUtil.format("task:{} --- poolActiveCount:{} --- undoneCount:{}",
                        j, threadPoolExecutor.getActiveCount(), undoneCount.get()));
                Try.run(() ->
                        // 模拟任务执行耗时
                        Thread.sleep(RandomUtil.randomInt(1000, 3000))
                );
                if (blockingQueue.size() > 0) {
                    submitTask(blockingQueue.poll(), undoneCount);
                }
            });
        }

        for (int i = 0; i < Math.min(taskSize, size); i++) {
            submitTask(blockingQueue.poll(), undoneCount);
        }
    }

    public static void submitTask(Runnable runnable, AtomicInteger undoneCount) {
        CompletableFuture.runAsync(runnable, threadPoolExecutor)
                .thenRun(() -> {
                    undoneCount.getAndDecrement();
                    if (undoneCount.get() == 0) {
                        System.out.println("任务执行完毕");
                    }
                });
    }
}
