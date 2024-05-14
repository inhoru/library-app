package com.group.libraryapp.dto.fruit.reponse;

import com.group.libraryapp.domain.fruit.Fruit;

public class FruitSoldResponse {

    private long sold;

    private long notsold;

    public FruitSoldResponse() {
    }

    public FruitSoldResponse(long sold, long notsold) {
        this.sold = sold;
        this.notsold = notsold;
    }

    public long getSold() {
        return sold;
    }

    public long getNotsold() {
        return notsold;
    }
}
