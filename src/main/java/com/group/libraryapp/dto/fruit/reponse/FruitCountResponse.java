package com.group.libraryapp.dto.fruit.reponse;

public class FruitCountResponse {
    private String name;
    private long count;

    public FruitCountResponse() {

    }

    public FruitCountResponse(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }
}
