package com.maxdemaio.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BlogPostService srv = (BlogPostService) context.getBean("blogPostService");
        srv.generatepost();
    }

}