package com.maxdemaio.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BlogPostService srv = (BlogPostService) context.getBean("blogPostService");
        System.out.println(srv.getGens());
    }

}
