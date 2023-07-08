package com.vivek.learnoauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(Authentication authentication) {
        log.info(String.valueOf(authentication));
        return "Hello World!";
    }

}
