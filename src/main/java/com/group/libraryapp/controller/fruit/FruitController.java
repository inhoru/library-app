package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.reponse.FruitCountResponse;
import com.group.libraryapp.dto.fruit.reponse.FruitListResponse;
import com.group.libraryapp.dto.fruit.reponse.FruitSoldResponse;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void soldFruit(@RequestBody FruitUpdateRequest request) {
        fruitService.soldFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitSoldResponse getFruitIsSoldOrNot(@RequestParam String name) {
        return fruitService.getFruitIsSoldOrNot(name);
    }
    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse getFruitCount(@RequestParam String name){
        return fruitService.getFruitCount(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public  List<FruitListResponse> listFruit(@RequestParam String option, long price){
        return fruitService.getFruitList(option,price);
    }

//    @GetMapping("/api/v1/fruit/stat")
//    public FruitSoldResponse getFruitIsSoldOrNot(@RequestParam String name) {
//        Map<Long, Long> result = jdbcTemplate.query(
//                        "select sold, sum(price) from fruit where name = ? group by sold",
//                        (rs, rowNum) -> {
//                            Long isSold = rs.getLong("sold");
//                            long sum = rs.getLong(2);
//                            return Map.entry(isSold, sum);
//                        },
//                        name
//                ).stream()
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        Long sold = result.getOrDefault(1L, 0L);
//        Long notSold = result.getOrDefault(0L, 0L);
//
//        return new FruitSoldResponse(sold, notSold);
//    }

}
