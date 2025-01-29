package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int age;

//    field injection
//    @Autowired
//    @Qualifier("laptop")
    private Computer com;
/// now we can assign desktop or laptop to alien
    public Alien(){
        System.out.println("Alien created");
    }

//    construction injection
    @Autowired
    public Alien (@Qualifier("laptop") Computer com){
        this.com = com;
    }
    public int getAge() {
        return age;
    }

    public Computer getCom() {
        return com;
    }

//    setter injection
//    @Autowired
//    @Qualifier("desktop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public void code(){
        System.out.println("coding");
        com.compile();
    }
}
