package com.group.libraryapp.dto.fruit.request;

import java.time.LocalDate;

public class FruitUpdateRequest {

    private long id;

    public FruitUpdateRequest() {
    }

    public FruitUpdateRequest(long id, long sold) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}

