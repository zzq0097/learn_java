package com.zzq.learn.mq.rabbitmq;

import lombok.Getter;

@Getter
public enum QueueEnum {
    QUEUE("sys.queue", "sys.exchange", "sys.key"),
    TTL_QUEUE("sys.ttl.queue", "sys.ttl.exchange", "sys.ttl.key"),
    DEAD_QUEUE("sys.dead.queue", "sys.dead.exchange", "sys.dead.key");

    private final String queueName;
    private final String exchangeName;
    private final String routingKey;

    QueueEnum(String queueName, String exchangeName, String routingKey) {
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }
}
