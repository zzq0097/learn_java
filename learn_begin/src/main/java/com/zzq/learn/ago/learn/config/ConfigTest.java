package com.zzq.learn.ago.learn.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConditionalOnProperty(value = "spring.profiles.active", havingValue = "outer")
@PropertySource(value = "test.yaml", encoding = "utf-8")
@Configuration
public class ConfigTest {


}
