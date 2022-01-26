package com.maxdemaio.demo;

public class CoolPostGenerator implements PostGenerator {

	@Override
	public String generatePost(int wordCount) {
		
		return "Generated cool post with " + wordCount + " words";
	}
}