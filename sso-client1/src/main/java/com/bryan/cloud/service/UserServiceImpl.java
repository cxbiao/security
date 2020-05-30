package com.bryan.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


   //public static String SERVIER_NAME = "gateway/micro-order";
    //用网关访问有点问题
    public static String SERVIER_NAME = "micro-order";

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public List<String> queryContents(HttpServletRequest request) {
        log.info(Thread.currentThread().getName() + "========queryContents=========");
        HttpHeaders headers = new HttpHeaders();
       // headers.add("Authorization", request.getHeader("Authorization"));
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);//不是json请求
        //网关的appId，appSecret，需要在数据库oauth_client_details注册
        headers.setBasicAuth("james","123456");
        List<String> results = restTemplate.exchange("http://"
                        + SERVIER_NAME + "/client2/user/queryContent", HttpMethod.GET,
                new HttpEntity<String>(headers), List.class).getBody();
//        List<String> results = restTemplate.exchange("http://"
//                        + SERVIER_NAME + "/user/queryContent", HttpMethod.GET,null,
//                 List.class).getBody();
        return results;
    }


}
