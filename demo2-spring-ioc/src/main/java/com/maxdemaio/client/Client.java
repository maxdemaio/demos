package com.maxdemaio.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maxdemaio.service.BlogPostService;

public class Client {

    public static void main(String[] args) {

        // ApplicationContext container is instantiated by loading the configuration
        // from config.xml available in application classpath
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        // Access bean with id “blogPostService"
        // Typecast from Object type to blogPostService type
        BlogPostService blogPostService = (BlogPostService) context.getBean("blogPostService");
        // Invoke display method of blogPostService to display greeting on console
        blogPostService.display();
    }

}