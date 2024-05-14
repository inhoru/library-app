package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.domain.date.Date;
import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.date.DateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;


@RestController
public class CalculatorController {


    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") // POST //multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();

    }
    @GetMapping("api/v1/day-of-the-week")
    public DateResponse calc(Date request){
        LocalDate date = request.getDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return new DateResponse(dayOfWeek);
    }
}

