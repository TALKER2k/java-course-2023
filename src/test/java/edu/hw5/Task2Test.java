package edu.hw5;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testGetAllFriday13th() {
        Task2 task = new Task2();

        final int year = 2000;
        final int month = 10;
        final int dayOfMonth = 13;
        List<LocalDate> correctList = List.of(LocalDate.of(year, month, dayOfMonth));

        List<LocalDate> result = task.getAllFriday13th(year);

        assertEquals(correctList, result);
    }
}
