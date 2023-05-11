package com.zzq.learn_eureka_discovery_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LearnEurekaDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnEurekaDiscoveryServerApplication.class, args);
    }

}
