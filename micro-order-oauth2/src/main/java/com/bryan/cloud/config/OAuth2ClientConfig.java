package com.bryan.cloud.config;

import org.springframework.context.annotation.Configuration;

/*
  鉴权过滤器
* @  OAuth2AuthenticationProcessingFilter
*
* */
//@EnableOAuth2Client
//@EnableConfigurationProperties
@Configuration
public class OAuth2ClientConfig {


//    @Bean
//    @ConfigurationProperties(prefix = "security.oauth2.client")
//    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
//        return new ClientCredentialsResourceDetails();
//    }

//    @Bean
//    public RequestInterceptor oauth2FeignRequestInterceptor(ClientCredentialsResourceDetails clientCredentialsResourceDetails) {
//        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
//    }

//    @Bean
//    public OAuth2RestTemplate clientCredentialsRestTemplate() {
//        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
//    }
}
