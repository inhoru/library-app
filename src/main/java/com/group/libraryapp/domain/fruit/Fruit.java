package com.group.libraryapp.domain.fruit;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false, name = "stocked_date")
    private LocalDate warehousingDate;
    @Column(nullable = false)
    private int sold = 0;

    public Fruit() {
    }

    public Fruit(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public Long getId() {
        return id;
    }

    public int getSold() {
        return sold;
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

    public void updateSold() {
        this.sold = 1;
    }
}
