package com.zzq.learn.config.bean;

import com.zzq.learn.consts.Sys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {
    private final static int corePoolSize = Sys.AvailableProcessors * 2;
    private final static int maxPoolSize = 100;
    private final static long keepAliveTime = 60 * 30;
    private final static int blockQueueSize = 100;

    @Bean("customThreadPool")
    public ThreadPoolExecutor customThreadPool() {
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(blockQueueSize));
    }
}
