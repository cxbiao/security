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


    public static String SERVIER_NAME = "gateway/micro-order";

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public List<String> queryContents(HttpServletRequest request) {
        log.info(Thread.currentThread().getName() + "========queryContents=========");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", request.getHeader("Authorization"));
        List<String> results = restTemplate.exchange("http://"
                        + SERVIER_NAME + "/user/queryContent", HttpMethod.GET,
                new HttpEntity<String>(headers), List.class).getBody();
//        List<String> results = restTemplate.exchange("http://"
//                        + SERVIER_NAME + "/user/queryContent", HttpMethod.GET,null,
//                 List.class).getBody();
        return results;
    }


}
