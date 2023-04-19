package com.zzq.learn_oauth2_client;

import com.zzq.learn_oauth2_client.model.dto.TestClient;
import me.zhyd.oauth.AuthRequestBuilder;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JustAuthTest {


    @Test
    public void test() {
        AuthRequest authRequest = AuthRequestBuilder.builder()
                .source("other")
                .authConfig(AuthConfig.builder()
                        .clientId(TestClient.clientId)
                        .clientSecret(TestClient.clientSecret)
                        .build())
                .build();

        System.out.println(authRequest.authorize("state"));
    }


}
