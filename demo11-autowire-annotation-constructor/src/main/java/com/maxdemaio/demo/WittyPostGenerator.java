package com.maxdemaio.demo;

import org.springframework.stereotype.Component;

@Component
public class WittyPostGenerator implements PostGenerator {

	@Override
	public String generatePost( int wordCount) {

		return "Generated witty post with " + wordCount + " words";

	}

}
