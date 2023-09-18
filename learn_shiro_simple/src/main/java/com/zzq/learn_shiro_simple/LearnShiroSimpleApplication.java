package com.zzq.learn_shiro_simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.zzq.learn_shiro_simple.mapper"})
@SpringBootApplication
public class LearnShiroSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnShiroSimpleApplication.class, args);
    }

}
