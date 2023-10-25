package com.zzq.learn_zookeeper_discovery_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LearnZookeeperDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnZookeeperDiscoveryConsumerApplication.class, args);
    }

}
