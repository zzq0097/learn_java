package com.zzq.learn_oauth2_server.config.security.custom;

import com.zzq.learn_oauth2_server.sys.user.SysUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MultipleSystemAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private final String systemId;
    private SysUser sysUser = null;

    public MultipleSystemAuthenticationToken(Object principal, Object credentials, String systemId) {
        super(principal, credentials);
        this.systemId = systemId;
    }

    public MultipleSystemAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, SysUser sysUser) {
        super(principal, credentials, authorities);
        this.systemId = sysUser.getSystemId();
        this.sysUser = sysUser;
    }

    public String getSystemId() {
        return systemId;
    }

    public SysUser getSysUser() {
        return sysUser;
    }
}
