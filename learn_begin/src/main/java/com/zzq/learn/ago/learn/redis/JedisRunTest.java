package com.zzq.learn.ago.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisRunTest {

    public static void main(String[] args) {
        Jedis jedis;
        try (JedisPool jedisPool = new JedisPool("8.131.66.130", 10779)) {
            jedis = jedisPool.getResource();
            jedis.auth("123456");
        }
        System.out.println(jedis.get("test"));

        jedis.set("test", "qwer");

        System.out.println(jedis.get("test"));

    }
}
