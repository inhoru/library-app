package com.group.libraryapp.domain.fruit;

import java.time.LocalDate;

public class Fruit {

    private String name;
    private Long price;
    private LocalDate localDate;

    public Fruit(String name, Long price, LocalDate localDate) {
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
