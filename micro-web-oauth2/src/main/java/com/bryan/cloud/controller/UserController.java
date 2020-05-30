package com.bryan.cloud.controller;


import com.bryan.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


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

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/queryUser")
    public List<String> queryUser(HttpServletRequest request) {
        String id = request.getSession().getId();
        SecurityContext context = SecurityContextHolder.getContext();
        OAuth2Authentication authentication = (OAuth2Authentication) context.getAuthentication();
        //用户信息在details中 principal -> {LinkedHashMap@9774}  size = 8
        Map details= (Map) authentication.getUserAuthentication().getDetails();
        log.info(details.toString());

        request.getCookies();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headername = headerNames.nextElement();
            log.info("header name = >" + headername + "= >" + "headervalue = " + request.getHeader(headername));
        }
        return userService.queryContents(request);
    }


}
