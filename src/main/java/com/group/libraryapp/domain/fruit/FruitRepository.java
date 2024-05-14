package com.group.libraryapp.domain.fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findByNameAndSold(String name, int sold);

    long countByName(String name);

    List<Fruit> findAllByPriceGreaterThanEqualAndSold(long price,int sold);
    List<Fruit> findAllByPriceLessThanEqualAndSold(long price,int sold);
}
