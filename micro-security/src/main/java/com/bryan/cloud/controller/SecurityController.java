package com.bryan.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping(value = "/check")
    public Principal getUser(Principal principal) {
        log.info("checkUser:=>"+principal.toString());
        return principal;
    }
}
