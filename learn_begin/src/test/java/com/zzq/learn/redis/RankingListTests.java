package com.zzq.learn.redis;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import jakarta.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SpringBootTest
public class RankingListTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String key = "rankingList";

    private final static String[] names = {"张三", "李四", "王五"};

    /**
     * 初始化排行榜
     */
    @Test
    public void initList() {
        ZSetOperations<String, Object> redisZSet = redisTemplate.opsForZSet();
        Set<TypedTuple<Object>> tuples = new HashSet<>();
        for (String name : names) {
            tuples.add(TypedTuple.of(name, 0.0));
        }
        redisZSet.add(key, tuples);
    }

    /**
     * 增加积分
     */
    @Test
    public void plus() {
        ZSetOperations<String, Object> redisZSet = redisTemplate.opsForZSet();
        for (int i = 0; i < 10; i++) {
            String name = names[RandomUtil.randomInt(0, names.length)];
            redisZSet.incrementScore(key, name, 1.0);
        }
    }

    /**
     * 获取排行榜列表
     */
    @Test
    public void get() {
        ZSetOperations<String, Object> redisZSet = redisTemplate.opsForZSet();
        System.out.println("rankingList");
        for (TypedTuple<Object> tuple : Objects.requireNonNull(redisZSet.reverseRangeWithScores(key, 0, -1))) {
            System.out.println(tuple);
        }
    }
}
