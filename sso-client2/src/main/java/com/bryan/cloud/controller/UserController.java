package com.bryan.cloud.controller;

import com.bryan.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Value的注解刷新需要加上  @RefreshScope ,因为@Value容器启动时就已经注入好了
 * environment 不需要加
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //http://192.168.210.2:8701/user/queryContent
    @RequestMapping("/queryContent")
    public List<String> queryContent(HttpServletRequest request) {
        log.info("queryContent======");

        return userService.queryContent();
    }





}
