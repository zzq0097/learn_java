package com.zzq.learn.config.bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue directQueue() {
        return new Queue("directQueue", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange", true, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("directRouting");
    }

}
