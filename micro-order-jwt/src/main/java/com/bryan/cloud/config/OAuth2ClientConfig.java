package com.bryan.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
//    @LoadBalanced
//    public OAuth2RestTemplate clientCredentialsRestTemplate() {
//        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
//    }

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }
}
