package com.allteran.mirage.workshopservice.config;

import com.google.common.net.HttpHeaders;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_TYPE = "Bearer";

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//    }

    @PostConstruct
    public void enableAuthenticationContextOnSpawnedThreads() {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return requestTemplate -> {
            JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            System.out.println("token is: " + token.getToken().getTokenValue());
            requestTemplate.header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token.getToken().getTokenValue()));
        };
    }

    //	@Bean
//	public RequestInterceptor requestTokenBearerInterceptor() {
//		return requestTemplate -> {
//			JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext()
//					.getAuthentication();
//			requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
//		};
//	}
}
