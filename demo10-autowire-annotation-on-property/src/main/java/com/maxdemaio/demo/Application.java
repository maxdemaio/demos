package com.maxdemaio.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BlogPostService srv = (BlogPostService) context.getBean("blogPostService");
        srv.generatepost();
        context.close();
    }

}