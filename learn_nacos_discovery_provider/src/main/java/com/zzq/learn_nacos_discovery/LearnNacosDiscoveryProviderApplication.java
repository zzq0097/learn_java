package com.zzq.learn_nacos_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableDiscoveryClient
@SpringBootApplication
@Controller
public class LearnNacosDiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnNacosDiscoveryProviderApplication.class, args);
    }

    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
