package com.zzq.learn_zookeeper_discovery_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class LearnZookeeperDiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnZookeeperDiscoveryProviderApplication.class, args);
    }

    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "provider say hello";
    }

}
