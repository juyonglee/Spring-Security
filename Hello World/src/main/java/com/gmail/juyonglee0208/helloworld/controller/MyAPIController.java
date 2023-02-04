package com.gmail.juyonglee0208.helloworld.controller;

import com.gmail.juyonglee0208.helloworld.dto.MySecurityRes;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class MyAPIController {

    @GetMapping
    public @ResponseBody
    Authentication authInfo() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public MySecurityRes getAdminInfo() {
        return MySecurityRes.builder()
            .authentication(SecurityContextHolder.getContext().getAuthentication())
            .message("해당 사용자는 ADMIN 권한을 가지고 있습니다.").build();
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public MySecurityRes getUserInfo() {
        return MySecurityRes.builder()
            .authentication(SecurityContextHolder.getContext().getAuthentication())
            .message("해당 사용자는 USER 권한을 가지고 있습니다.").build();
    }
}
