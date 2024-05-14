package com.group.libraryapp.domain.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {

    private LocalDate date;
    private DayOfWeek dayOfWeek;

    public Date(LocalDate date, DayOfWeek dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDate getDate() {
        return date;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

}
