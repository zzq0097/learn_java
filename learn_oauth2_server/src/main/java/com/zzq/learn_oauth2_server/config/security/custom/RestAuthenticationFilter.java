package com.zzq.learn_oauth2_server.config.security.custom;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.zzq.learn_oauth2_server.common.constants.Sys;
import com.zzq.learn_oauth2_server.common.model.resp.R;
import com.zzq.learn_oauth2_server.sys.user.SysUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2AccessTokenGenerator;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public RestAuthenticationFilter(AuthenticationManager authenticationManager, OAuth2AuthorizationService oAuth2AuthorizationService) {
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType(ContentType.JSON.getValue());
            response.getWriter().print(JSONUtil.toJsonStr(R.fail()));
        });
        setAuthenticationSuccessHandler(((request, response, authentication) -> {
            MultipleSystemAuthenticationToken authenticationToken = (MultipleSystemAuthenticationToken) authentication;
            SysUser sysUser = authenticationToken.getSysUser();

            OAuth2AccessToken accessToken = new OAuth2AccessTokenGenerator().generate(DefaultOAuth2TokenContext.builder()
                    .registeredClient(Sys.DefaultClient)
                    .tokenType(OAuth2TokenType.ACCESS_TOKEN)
                    .principal(authentication)
                    .build());

            oAuth2AuthorizationService.save(OAuth2Authorization
                    .withRegisteredClient(Sys.DefaultClient)
                    .token(accessToken, stringObjectMap -> {
                        Map<String, Object> claims = new HashMap<>();
                        claims.put("user", sysUser);
                        stringObjectMap.put(OAuth2Authorization.Token.CLAIMS_METADATA_NAME, claims);
                    })
                    .principalName(authentication.getName())
                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                    .attribute("state", accessToken.getTokenValue())
                    .build());

            response.setContentType(ContentType.JSON.getValue());
            response.getWriter().print(JSONUtil.toJsonStr(R.ok(accessToken.getTokenValue())));
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
