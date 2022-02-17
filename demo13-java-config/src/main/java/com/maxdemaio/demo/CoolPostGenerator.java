package com.maxdemaio.demo;

import org.springframework.stereotype.Component;

@Component
public class CoolPostGenerator implements PostGenerator {

	@Override
	public String generatePost(int wordCount) {

		return "Generated cool post with " + wordCount + " words";
	}
}