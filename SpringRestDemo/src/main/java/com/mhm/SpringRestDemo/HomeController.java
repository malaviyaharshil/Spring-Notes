package com.mhm.SpringRestDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }
    @GetMapping("/greet")
    public String greet2(){
        return "Welcome to my first Spring Boot Deployed Application";
    }
}
