package com.maxdemaio.demo;

public class BlogPostService {

    private PostGenerator gen;
    private int wordCount;

    public BlogPostService(PostGenerator gen, int wordCount) {
        System.out.println("Parameterized Constructor");
        this.gen = gen;
        this.wordCount = wordCount;
    }


    public BlogPostService() {

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

    public void generatePost() {
        System.out.println(gen.generatePost(wordCount));
    }
}
