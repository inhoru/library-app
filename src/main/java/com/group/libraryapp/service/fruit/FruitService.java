package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.fruit.reponse.FruitCountResponse;
import com.group.libraryapp.dto.fruit.reponse.FruitListResponse;
import com.group.libraryapp.dto.fruit.reponse.FruitSoldResponse;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.user.reponse.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getPrice(), request.getWarehousingDate()));
    }

    @Transactional
    public void soldFruit(FruitUpdateRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        fruit.updateSold();
        fruitRepository.save(fruit);
    }

    @Transactional(readOnly = true)
    public FruitSoldResponse getFruitIsSoldOrNot(String name) {
        long sold = fruitRepository.findByNameAndSold(name, 1).stream().mapToLong(Fruit::getPrice).sum();
        long notSold = fruitRepository.findByNameAndSold(name, 0).stream().mapToLong(Fruit::getPrice).sum();
        return new FruitSoldResponse(sold, notSold);

    }

    @Transactional(readOnly = true)
    public FruitCountResponse getFruitCount(String name){
        long count = fruitRepository.countByName(name);
        return new FruitCountResponse(name, count);
    }
    @Transactional(readOnly = true)
    public List<FruitListResponse> getFruitList(String option,long price){
        List<Fruit> fruits;
        if (option.equals("GTE")) {
            fruits = fruitRepository.findAllByPriceGreaterThanEqualAndSold(price, 0);
        } else if (option.equals("LTE")) {
            fruits = fruitRepository.findAllByPriceLessThanEqualAndSold(price, 0);
        } else {
            throw new IllegalArgumentException();
        }
        return fruits.stream()
                .map(FruitListResponse::new)
                .collect(Collectors.toList());

    }


}
