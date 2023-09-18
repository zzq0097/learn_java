//package com.zzq.learn.config.security;
//
//import com.zzq.learn.mapper.SysUserMapper;
//import com.zzq.learn.model.entity.SysUser;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig {
//    private final SysUserMapper sysUserMapper;
//
//    private final static String[] pass = {
//            "/user/login2",
//            "/user/code"
//    };
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeHttpRequests()
//                .requestMatchers(pass).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            SysUser sysUser = sysUserMapper.selectByUsername(username);
//            if (sysUser != null) {
//                return User.builder()
//                        .username(sysUser.getUsername())
//                        .password(passwordEncoder().encode(sysUser.getPassword()))
//                        .authorities("ROLE_ADMIN", "admin:all")
//                        .build();
//            }
//            throw new UsernameNotFoundException("用户不存在");
//        };
//    }
//
//}
