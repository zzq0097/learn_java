package com.zzq.learn_eureka_discovery_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LearnEurekaDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnEurekaDiscoveryConsumerApplication.class, args);
    }

}
