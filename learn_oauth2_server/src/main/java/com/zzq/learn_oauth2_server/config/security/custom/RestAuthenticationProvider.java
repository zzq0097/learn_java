package com.zzq.learn_oauth2_server.config.security.custom;

import com.zzq.learn_oauth2_server.sys.user.SysUser;
import com.zzq.learn_oauth2_server.sys.user.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MultipleSystemAuthenticationToken multipleSystemAuthenticationToken = (MultipleSystemAuthenticationToken) authentication;
        String systemId = multipleSystemAuthenticationToken.getSystemId();
        String username = multipleSystemAuthenticationToken.getName();
        String password = multipleSystemAuthenticationToken.getCredentials().toString();
        SysUser sysUser = sysUserMapper.selectUserWithSystemId(systemId, username, password).orElseThrow(() -> new AuthenticationServiceException(""));
        return new MultipleSystemAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("hahah", "dasdad"), sysUser);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(MultipleSystemAuthenticationToken.class);
    }

}
