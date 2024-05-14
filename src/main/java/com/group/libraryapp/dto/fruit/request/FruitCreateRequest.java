package com.group.libraryapp.dto.fruit.request;

import java.time.LocalDate;

public class FruitCreateRequest {
    private String name;
    private Long price;
    private LocalDate warehousingDate;

    public FruitCreateRequest(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public FruitCreateRequest() {
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}

