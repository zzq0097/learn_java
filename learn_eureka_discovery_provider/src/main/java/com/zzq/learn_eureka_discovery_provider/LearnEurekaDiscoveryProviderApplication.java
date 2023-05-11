package com.zzq.learn_eureka_discovery_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class LearnEurekaDiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnEurekaDiscoveryProviderApplication.class, args);
    }

    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "provider say hello";
    }
}
