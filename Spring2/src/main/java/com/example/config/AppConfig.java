package com.example.config;

import com.example.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example")
public class AppConfig {

    @Bean
    public Alien alien( Computer com){ //@Qualifier("desktop")
        Alien obj = new Alien();
        obj.setAge(21);
        obj.setCom(com);
        return obj;
    }

    @Bean("com2")
//    @Bean(name={"com2","desktop1"})
//    @Bean
    @Scope("prototype")
    @Primary
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
//    @Primary
    public Laptop laptop(){
        return new Laptop();
    }
}
