package com.zzq.learn_oauth2_server.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2AccessTokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenClaimsContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenClaimsSet;
import org.springframework.stereotype.Service;

@Service
public class Oauth2Service {
    @Autowired
    RegisteredClientRepository registeredClientRepository;


    public void login() {

    }

    public String generatorAccessToken() {
        OAuth2AccessTokenGenerator tokenGenerator = new OAuth2AccessTokenGenerator();

        tokenGenerator.setAccessTokenCustomizer(context -> {
            context.getClaims().claim("aaa", "bbb").build();
        });


        OAuth2AccessToken accessToken = tokenGenerator.generate(OAuth2TokenClaimsContext.with(OAuth2TokenClaimsSet.builder()
                        .claim("aaa", "bbb"))
                .registeredClient(registeredClientRepository.findByClientId("messaging-client"))
                .tokenType(OAuth2TokenType.ACCESS_TOKEN)
                .build());

        OAuth2AccessToken accessToken2 = tokenGenerator.generate(
                JwtEncodingContext.with(
                        JwsHeader.with(SignatureAlgorithm.ES256),
                        JwtClaimsSet.builder()
                ).build());
        return accessToken.getTokenValue();
    }


}
