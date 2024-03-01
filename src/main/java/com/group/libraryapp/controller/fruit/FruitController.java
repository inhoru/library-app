package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.reponse.FruitSoldResponse;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FruitController {

    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        String sql = "insert into fruit(name, stocked_date, price) values (?,?,?)";
        Fruit fruit = new Fruit(request.getName(),request.getPrice(),request.getLocalDate());
        jdbcTemplate.update(sql,request.getName(),fruit.getLocalDate(),fruit.getPrice());

    }
    @PutMapping("/api/v1/fruit")
    public void soldFruit(@RequestBody FruitUpdateRequest request) {
        String readSql = "select * from fruit where id = ?";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "update fruit set sold = 1 where id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

//    @GetMapping("/api/v1/fruit/stat")
//    public FruitSoldResponse getFruitIsSoldOrNot(@RequestParam String name) {
//        Long sold = jdbcTemplate.queryForObject(
//                "select sum(price) from fruit where name = ? and sold = 1", (rs, rowNum) -> {
//                    Long sum = rs.getLong(1);
//                    return (sum != null) ? sum : 0L;
//                }
//        ,name);
//        Long notSold = jdbcTemplate.queryForObject(
//                "select coalesce(sum(price),0) from fruit where name = ? and sold = 0", Long.class, name
//        );
//        FruitSoldResponse response = new FruitSoldResponse(sold, notSold);
//        return response;
//    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitSoldResponse getFruitIsSoldOrNot(@RequestParam String name) {
        Map<Long, Long> result = jdbcTemplate.query(
                        "select sold, sum(price) from fruit where name = ? group by sold",
                        (rs, rowNum) -> {
                            Long isSold = rs.getLong("sold");
                            long sum = rs.getLong(2);
                            return Map.entry(isSold, sum);
                        },
                        name
                ).stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Long sold = result.getOrDefault(1L, 0L);
        Long notSold = result.getOrDefault(0L, 0L);

        return new FruitSoldResponse(sold, notSold);
    }

}
