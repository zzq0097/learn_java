package com.zzq.learn.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import jakarta.annotation.Resource;
import java.time.Duration;

@SpringBootTest
public class RedisLockTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void lock() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Boolean getLock = opsForValue.setIfAbsent("lock:test", "1", Duration.ofMinutes(30));
        System.out.println(getLock);
    }
}
