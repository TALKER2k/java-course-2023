package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public List<LocalDate> getAllFriday13th(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);

        List<LocalDate> fridays = new ArrayList<>();

        while (date != null) {
            date = getNextFriday13th(date);
            if (date != null) {
                fridays.add(date);
            }
        }

        return fridays;
    }

    private LocalDate getNextFriday13th(LocalDate date) {
        LocalDate currentDate = date;

        while (currentDate.getYear() == date.getYear()) {
            final int twelve = 12;
            currentDate = currentDate.with(TemporalAdjusters.firstDayOfNextMonth()).plusDays(twelve);

            if (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                return currentDate;
            }
        }
        return null;
    }
}
