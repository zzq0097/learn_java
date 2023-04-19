package com.zzq.learn_oauth2_server.sys.user;

import lombok.Data;

@Data
public class SysUser {
    private Long userId;
    private String username;
    private String password;
    private String systemId;
}
