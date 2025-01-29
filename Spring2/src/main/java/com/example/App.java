package com.example;

import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
        Alien obj = context.getBean(Alien.class);
        System.out.println(obj.getAge());
        obj.code();

//        Desktop d = context.getBean("com2",Desktop.class);
//        d.compile();
//
//        Desktop d1 = context.getBean("desktop",Desktop.class);
//        d1.compile();








////        create container
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
////        making object through spring
//
//        Alien obj = (Alien) context.getBean("alien");
//        System.out.println(obj.getAge());
//        obj.code();

    }
}
