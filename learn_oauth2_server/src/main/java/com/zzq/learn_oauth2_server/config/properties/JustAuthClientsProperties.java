package com.zzq.learn_oauth2_server.config.properties;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import me.zhyd.oauth.AuthRequestBuilder;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "just-auth")
public class JustAuthClientsProperties {
    private Map<String, Client> clients;

    public static Map<String, AuthRequest> authRequestMap = new HashMap<>();

    @PostConstruct
    private void setAuthRequestMap() {
        clients.forEach((source, client) -> {
            authRequestMap.put(source, AuthRequestBuilder.builder()
                    .source(source)
                    .authConfig(AuthConfig.builder()
                            .clientId(client.getClientId())
                            .clientSecret(client.getClientSecret())
                            .redirectUri(client.getRedirectUri())
                            .build()
                    ).build());
        });
    }

    @Getter
    @Setter
    static class Client {
        private String clientId;
        private String clientSecret;
        private String redirectUri;
    }
}
