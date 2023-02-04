package com.gmail.juyonglee0208.helloworld.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAPIController {

    @GetMapping("/auth")
    public @ResponseBody
    Authentication authInfo() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
