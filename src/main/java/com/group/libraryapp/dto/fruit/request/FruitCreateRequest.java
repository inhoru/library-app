package com.group.libraryapp.dto.fruit.request;

import java.time.LocalDate;

public class FruitCreateRequest {
    private String name;
    private Long price;
    private LocalDate localDate;

    public FruitCreateRequest(String name, Long price, LocalDate localDate) {
        this.name = name;
        this.price = price;
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}

