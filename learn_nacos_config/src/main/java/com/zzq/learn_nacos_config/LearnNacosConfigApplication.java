package com.zzq.learn_nacos_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LearnNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnNacosConfigApplication.class, args);
    }

}
