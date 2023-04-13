package com.zzq.learn_oauth2_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> stringRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> stringRedisTemplate = new RedisTemplate<>();
        stringRedisTemplate.setConnectionFactory(connectionFactory);
        stringRedisTemplate.setDefaultSerializer(RedisSerializer.string());
        return stringRedisTemplate;
    }

}
