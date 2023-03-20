package com.zzq.learn.config.security;

import com.zzq.learn.model.entity.SysUser;
import com.zzq.learn.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final ISysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SysUser> sysUserList = userService.lambdaQuery().eq(SysUser::getUsername, username).list();
        if (sysUserList.isEmpty()) {
            throw new UsernameNotFoundException("用户不存在");
        } else if (sysUserList.size() > 1) {
            throw new RuntimeException("");
        } else {
            SysUser sysUser = sysUserList.get(0);
            return User.builder()
                    .username(sysUser.getUsername())
                    .password(sysUser.getPassword())
                    .build();
        }
    }
}
