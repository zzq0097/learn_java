package com.zzq.learn.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;

@SpringBootTest
public class SimpleTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        rabbitTemplate.send("directExchange", "directRouting", new Message("Hello".getBytes()));
    }

}
