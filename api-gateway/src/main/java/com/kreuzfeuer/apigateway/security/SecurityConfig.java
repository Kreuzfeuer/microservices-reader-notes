package com.kreuzfeuer.apigateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges ->
                        exchanges
                                .pathMatchers("/actuator/**")
                                .permitAll()
                                .anyExchange().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return http.build();

    }
}
