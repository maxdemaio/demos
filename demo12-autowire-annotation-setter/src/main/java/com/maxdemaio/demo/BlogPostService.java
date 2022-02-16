package com.maxdemaio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    @Autowired
    @Qualifier("coolPostGenerator")
    private PostGenerator gen;

    @Value("100")
    private int wordCount;


    public BlogPostService() {
        System.out.println("default constructor");
    }

    public int getwordCount() {
        return wordCount;
    }

    public void setwordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public PostGenerator getgen() {
        return gen;
    }

    public void setgen(PostGenerator gen) {
        this.gen = gen;
    }

    public void generatepost() {
        System.out.println(gen.generatePost(wordCount));
    }
}
