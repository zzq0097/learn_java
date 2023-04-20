package com.zzq.learn_oauth2_server.config.security.custom;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.zzq.learn_oauth2_server.common.model.resp.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public RestAuthenticationFilter(AuthenticationManager authenticationManager, CustomTokenStore customTokenStore) {
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType(ContentType.JSON.getValue());
            response.getWriter().print(JSONUtil.toJsonStr(R.fail()));
        });
        setAuthenticationSuccessHandler(((request, response, authentication) -> {
            response.setContentType(ContentType.JSON.getValue());
            response.getWriter().print(JSONUtil.toJsonStr(R.ok(customTokenStore.generate(authentication))));
        }));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String systemId = request.getParameter("systemId");
        MultipleSystemAuthenticationToken token = new MultipleSystemAuthenticationToken(username, password, systemId);
        return getAuthenticationManager().authenticate(token);
    }
}
