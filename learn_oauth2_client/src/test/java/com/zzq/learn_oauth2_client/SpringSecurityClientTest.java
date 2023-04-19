package com.zzq.learn_oauth2_client;

import com.zzq.learn_oauth2_client.model.dto.TestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2ClientCredentialsGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

@SpringBootTest
public class SpringSecurityClientTest {


    public void test() {

        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("")
                .clientId(TestClient.clientId)
                .clientSecret(TestClient.clientSecret)
                .build();

        OAuth2ClientCredentialsGrantRequest credentialsGrantRequest = new OAuth2ClientCredentialsGrantRequest(clientRegistration);


        DefaultAuthorizationCodeTokenResponseClient client = new DefaultAuthorizationCodeTokenResponseClient();

        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("").build();


    }
}
