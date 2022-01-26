package com.maxdemaio.demo;

public class Client {

	public static void main(String[] args) {

		BlogPostService service = new BlogPostService();
		service.generatePost();
	}

}
