package com.zzq.learn_oauth2_server.config.security.custom;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.zzq.learn_oauth2_server.common.model.resp.R;
import com.zzq.learn_oauth2_server.sys.user.SysUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2AccessTokenGenerator;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.UUID;

public class RestAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public RestAuthenticationFilter(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType(ContentType.JSON.getValue());
            response.getWriter().print(JSONUtil.toJsonStr(R.fail()));
        });
        setAuthenticationSuccessHandler(((request, response, authentication) -> {
            MultipleSystemAuthenticationToken authenticationToken = (MultipleSystemAuthenticationToken) authentication;
            SysUser sysUser = authenticationToken.getSysUser();

            OAuth2AccessToken accessToken = new OAuth2AccessTokenGenerator().generate(DefaultOAuth2TokenContext.builder()
                    .registeredClient(RegisteredClient.withId(UUID.randomUUID().toString())
                            .clientId("messaging-client")
                            .clientSecret("{noop}secret")
                            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                            .authorizationGrantType(AuthorizationGrantType.PASSWORD)
                            .authorizationGrantType(AuthorizationGrantType.JWT_BEARER)
                            .redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
                            .redirectUri("http://127.0.0.1:8080/authorized")
                            .scope(OidcScopes.OPENID)
                            .scope(OidcScopes.PROFILE)
                            .scope("message.read")
                            .scope("message.write")
                            .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                            .tokenSettings(TokenSettings.builder().accessTokenFormat(OAuth2TokenFormat.REFERENCE).build())
                            .build())
                    .tokenType(OAuth2TokenType.ACCESS_TOKEN)
                    .principal(authentication)
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
