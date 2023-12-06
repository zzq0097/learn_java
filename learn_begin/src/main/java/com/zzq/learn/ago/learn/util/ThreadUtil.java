package com.zzq.learn.ago.learn.util;

import cn.hutool.http.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadUtil {

    public static List<Future<String>> execute(List<String> nodes) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<>();
        nodes.forEach(node -> {
            futureList.add(pool.submit(() -> HttpUtil.get(node)));
        });
        pool.shutdown();
        return futureList;
    }

    protected static String test() {
        return "test";
    }
}
