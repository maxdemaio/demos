package com.maxdemaio.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BlogPostService srv1 = (BlogPostService) context.getBean("blogPostService");
        BlogPostService srv2 = (BlogPostService) context.getBean("blogPostService");
        System.out.println("hash code of srv 1: " + srv1.hashCode());
        System.out.println("hash code of srv 2: " + srv2.hashCode());

    }

}
