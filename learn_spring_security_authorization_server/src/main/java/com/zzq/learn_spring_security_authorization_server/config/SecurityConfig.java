package com.zzq.learn_spring_security_authorization_server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzq.learn_spring_security_authorization_server.model.R;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
public class SecurityConfig {

    private final static String[] allowed = new String[]{
            "/oauth2/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requestMatcherRegistry -> requestMatcherRegistry
                        .requestMatchers(allowed).permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(configurer -> {
                    configurer.successHandler((request, response, authentication) -> {
                        writeJson(200, R.ok("token"), response);
                    });
                    configurer.failureHandler((request, response, exception) -> {
                        writeJson(401, R.fail("认证失败"), response);
                    });
                })
                .authenticationManager(this::doAuthentication)
                .exceptionHandling(configurer -> {
                    configurer.accessDeniedHandler((request, response, accessDeniedException) -> {
                        writeJson(403, R.fail("无权限"), response);
                    });
                    configurer.authenticationEntryPoint((request, response, authException) -> {
                        writeJson(401, R.fail("未登录"), response);
                    });
                });
        return http.build();
    }

    public Authentication doAuthentication(Authentication authentication) {
        // 从数据库查询
        String username = "admin";
        String password = "123456";
        String[] authorities = new String[]{"admin"};

        if (username.equals(authentication.getName()) && password.equals(authentication.getCredentials())) {
            return new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList(authorities));
        }
        throw new BadCredentialsException("用户名或密码错误");
    }

    public void writeJson(int status, R<?> r, HttpServletResponse response) {
        response.setStatus(status);
        response.addHeader("Content-Type", "application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            response.getWriter().print(objectMapper.writeValueAsString(r));
        } catch (Exception e) {
            log.error("响应写入失败", e);
        }
    }
}
