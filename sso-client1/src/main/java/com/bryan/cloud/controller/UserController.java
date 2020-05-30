package com.bryan.cloud.controller;


import com.bryan.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
/**
 * sso 客户端通过网关访问有点问题，还要再研究一下
 */
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/client")
    public String client(){
        return "sso-client";
    }


    @RequestMapping("/printInfo")
    public List<String> printInfo(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                log.info("cookie name = >" + cookies[i].getName() + "= >" + "cookie value = " + cookies[i].getValue());
            }
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headername = headerNames.nextElement();
            log.info("header name = >" + headername + "= >" + "headervalue = " + request.getHeader(headername));
        }

        return userService.queryContents(request);
    }

    @PreAuthorize("hasAuthority('MENU')")
    @RequestMapping("/aa")
    public String aa() {
        return "aa";
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping("/bb")
    public String bb() {
        return "aa";
    }

    //http://localhost:8700/client1/user/queryUser
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/queryUser")
    public List<String> queryUser(HttpServletRequest request) {
        request.getSession().getId();
        SecurityContext context = SecurityContextHolder.getContext();
        OAuth2Authentication authentication = (OAuth2Authentication) context.getAuthentication();
        //id等jwt中的附加信息在details这个map的decodedDetails中
        Object details = authentication.getDetails();
        request.getCookies();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headername = headerNames.nextElement();
            log.info("header name = >" + headername + "= >" + "headervalue = " + request.getHeader(headername));
        }
        return userService.queryContents(request);
    }


}
