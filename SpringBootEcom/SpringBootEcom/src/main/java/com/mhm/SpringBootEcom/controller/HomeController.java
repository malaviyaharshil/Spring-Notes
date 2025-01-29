package com.mhm.SpringBootEcom.controller;

import com.mhm.SpringBootEcom.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class HomeController {

    @GetMapping("/hello")
    public String greet(){
        return "Hello World";
    }


}
