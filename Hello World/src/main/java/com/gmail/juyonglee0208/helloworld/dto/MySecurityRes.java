package com.gmail.juyonglee0208.helloworld.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.Authentication;

@Data
@Builder
public class MySecurityRes {

    private Authentication authentication;
    private String message;
}
