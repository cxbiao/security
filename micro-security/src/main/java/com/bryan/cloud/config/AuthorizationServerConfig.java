package com.bryan.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    /*
    * AuthorizationServerEndpointsConfigurer：用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
    * */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)//若无，refresh_token会有UserDetailsService is required错误
                .tokenStore(tokenStore()).
                allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
    }

    /*
    * AuthorizationServerSecurityConfigurer 用来配置令牌端点(Token Endpoint)的安全约束
    * */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /*

        ClientDetailsServiceConfigurer：用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
    *   1.授权码模式（authorization code）
        2.简化模式（implicit）
        3.密码模式（resource owner password credentials）
        4.客户端模式（client credentials）
    * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        String finalSecret =   PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456");
        clients.
//                jdbc(dataSource).
                inMemory().
                withClient("micro-web")  //配置client_id
                .resourceIds("micro-web")   //没用
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("all","read", "write","aa")   //可以不传，要传要传对
                .authorities("client_credentialsxx")   //没用
                .secret(finalSecret)  //配置client-secret
                .accessTokenValiditySeconds(1200)  //配置访问token的有效期
                .refreshTokenValiditySeconds(50000)  //配置刷新token的有效期
                .and()
                .withClient("micro-zuul")
                .resourceIds("micro-zuul")
                .authorizedGrantTypes("password", "refresh_token")  //配置grant_type，表示授权类型
                .scopes("server")
                .authorities("password")
                .secret(finalSecret)
                .accessTokenValiditySeconds(1200)
                .refreshTokenValiditySeconds(50000);
    }
}
