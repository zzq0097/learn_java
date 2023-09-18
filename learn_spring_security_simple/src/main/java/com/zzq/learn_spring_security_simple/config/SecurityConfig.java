package com.zzq.learn_spring_security_simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final static String[] allowed = new String[]{
            "/login"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(requestMatcherRegistry -> requestMatcherRegistry
                .requestMatchers(allowed).permitAll()
                .anyRequest().authenticated());

        httpSecurity.formLogin(AbstractHttpConfigurer::disable);

        return httpSecurity.build();

    }
}
