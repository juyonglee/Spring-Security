package com.gmail.juyonglee0208.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String myFirstPage() {
        return "index.html";
    }
}
