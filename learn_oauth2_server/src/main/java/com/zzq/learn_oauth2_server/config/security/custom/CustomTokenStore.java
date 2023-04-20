package com.zzq.learn_oauth2_server.config.security.custom;

import com.zzq.learn_oauth2_server.common.constants.Sys;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2AccessTokenGenerator;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenStore {
    private final OAuth2AuthorizationService oAuth2AuthorizationService;

    public CustomTokenStore(OAuth2AuthorizationService oAuth2AuthorizationService) {
        this.oAuth2AuthorizationService = oAuth2AuthorizationService;
    }

    public String generate(Authentication authentication) {
        MultipleSystemAuthenticationToken authenticationToken = (MultipleSystemAuthenticationToken) authentication;

        // 生成AccessToken
        OAuth2AccessToken accessToken = new OAuth2AccessTokenGenerator().generate(DefaultOAuth2TokenContext.builder()
                .registeredClient(Sys.DefaultClient)
                .tokenType(OAuth2TokenType.ACCESS_TOKEN)
                .principal(authentication)
                .build());

        Assert.notNull(accessToken, "AccessToken生成失败");

        // 存起来 [/oauth2/introspect] 会验证这个token
        oAuth2AuthorizationService.save(OAuth2Authorization
                .withRegisteredClient(Sys.DefaultClient)
                // 添加token验证时的附加信息
                .token(accessToken, stringObjectMap -> {
                    Map<String, Object> claims = new HashMap<>();
                    claims.put("user", authenticationToken.getSysUser());
                    stringObjectMap.put(OAuth2Authorization.Token.CLAIMS_METADATA_NAME, claims);
                })
                .principalName(authentication.getName())
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .attribute("state", accessToken.getTokenValue())
                .build());

        return accessToken.getTokenValue();
    }

}
