package com.zzq.learn.redis;

import cn.hutool.core.date.DateUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.BitSet;
import java.util.Date;

@SpringBootTest
public class RedisBitMapTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String username = "皮皮帆";

    public String buildKey(String username, Date date) {
        return String.format("sign:%s:%d-%d", username, DateUtil.year(date), DateUtil.month(date));
    }

    /**
     * 签到
     */
    @Test
    public void sign() {
        Date now = new Date();
        int dayOfMonth = DateUtil.dayOfMonth(now);
        redisTemplate.opsForValue().setBit(buildKey(username, now), dayOfMonth - 1, true);
    }


    /**
     * 获取当月的签到次数
     */
    @Test
    public void getSignCount() {
        int count = 0;
        Date now = new Date();
        byte[] bytes = (byte[]) redisTemplate.opsForValue().get(buildKey(username, now));
        if (bytes != null) {
            BitSet bitSet = BitSet.valueOf(bytes);
            count = bitSet.cardinality();
        }
        System.out.println("count: " + count);
    }
}
