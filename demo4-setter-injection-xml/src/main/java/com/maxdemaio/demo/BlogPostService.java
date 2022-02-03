package com.maxdemaio.demo;

import java.util.List;

public class BlogPostService {
    private List<PostGenerator> gens;

    public void setGens(List<PostGenerator> gens) {
        this.gens = gens;
    }

    public List<PostGenerator> getGens() {
        return gens;
    }
}