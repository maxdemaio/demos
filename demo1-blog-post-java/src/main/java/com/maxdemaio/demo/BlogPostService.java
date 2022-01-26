package com.maxdemaio.demo;

public class BlogPostService {
	
	PostGenerator gen = new CoolPostGenerator();
	int wordCount = 100;
	public void generatePost() {
		System.out.println(gen.generatePost(wordCount));
	}
}
