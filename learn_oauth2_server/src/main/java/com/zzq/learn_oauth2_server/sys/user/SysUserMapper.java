package com.zzq.learn_oauth2_server.sys.user;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SysUserMapper {

    public Optional<SysUser> selectUserWithSystemId(String systemId, String username, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1L);
        sysUser.setSystemId("1");
        sysUser.setUsername("admin");
        sysUser.setPassword("admin");
        if (sysUser.getSystemId().equals(systemId)
                && sysUser.getUsername().equals(username)
                && sysUser.getPassword().equals(password)) {
            return Optional.of(sysUser);
        }
        return Optional.empty();
    }

}
