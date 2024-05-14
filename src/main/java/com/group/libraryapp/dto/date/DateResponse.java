package com.group.libraryapp.dto.date;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateResponse {
    private String dayOfTheWeek;

    public DateResponse(DayOfWeek dayOfWeek) {
        this.dayOfTheWeek = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;

    }
}