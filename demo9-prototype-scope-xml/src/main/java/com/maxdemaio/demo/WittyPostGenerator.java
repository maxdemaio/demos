package com.maxdemaio.demo;

public class WittyPostGenerator implements PostGenerator {

	@Override
	public String generatePost( int wordCount) {

		return "Generated witty post with " + wordCount + " words";

	}

}
