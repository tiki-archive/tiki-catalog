/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.main;

import com.mytiki.l0_index.features.FeaturesConfig;
import com.mytiki.l0_index.health.HealthConfig;
import com.mytiki.l0_index.security.SecurityConfig;
import com.mytiki.spring_rest_api.ApiExceptionHandlerDefault;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.annotation.PostConstruct;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.security.Security;
import java.util.Collections;
import java.util.TimeZone;

@Import({
        ApiExceptionHandlerDefault.class,
        SecurityConfig.class,
        HealthConfig.class,
        FeaturesConfig.class
})
public class AppConfig {
    @PostConstruct
    void starter() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Security.setProperty("crypto.policy", "unlimited");
        Security.addProvider(new BouncyCastleProvider());
    }

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("L0 Index")
                        .description("Searchable Index Service")
                        .version(appVersion)
                        .license(new License()
                                .name("MIT")
                                .url("https://github.com/tiki/l0-index/blob/main/LICENSE")))
                .servers(Collections.singletonList(new Server()
                                .url("https://index.l0.mytiki.com")))
                .components(new Components()
                        .addSecuritySchemes("oauth", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new OAuthFlows()
                                        .clientCredentials(new OAuthFlow()
                                                .tokenUrl("https://auth.l0.mytiki.com/api/latest/oauth/token")
                                                .refreshUrl("https://auth.l0.mytiki.com/api/latest/oauth/token")
                                                .scopes(new Scopes().addString("index","this service"))))));
    }
}

