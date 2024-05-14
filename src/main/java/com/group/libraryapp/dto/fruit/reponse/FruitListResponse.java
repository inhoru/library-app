package com.group.libraryapp.dto.fruit.reponse;

import com.group.libraryapp.domain.fruit.Fruit;

import java.time.LocalDate;

public class FruitListResponse {
    private String name;
    private long price;

    private LocalDate warehousingDate;

    public FruitListResponse() {
    }

    public FruitListResponse(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }
    public FruitListResponse(Fruit fruit){
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousingDate();
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
