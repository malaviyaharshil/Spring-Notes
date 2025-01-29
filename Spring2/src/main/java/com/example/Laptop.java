package com.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("com1")
@Component
public class Laptop implements Computer {
    public Laptop(){
        System.out.println("Laptop created");
    }
    @Override
    public void compile(){
        System.out.println("compiling on laptop");
    }
}
