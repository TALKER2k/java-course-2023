package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    public void testParseDate() {
        Task3 task = new Task3();

        final int year = 2020;
        final int dayOfMonth = 10;
        final int month1 = 10;
        final int month2 = 11;
        final int dayToSubtract = 3;

        String date1 = "2020-10-10";
        Optional<LocalDate> correctDate1 = Optional.of(LocalDate.of(year, month1, dayOfMonth));
        assertEquals(correctDate1, task.parseDate(date1));

        String date2 = "2020-1-1";
        Optional<LocalDate> correctDate2 = Optional.of(LocalDate.of(year, 1, 1));
        assertEquals(correctDate2, task.parseDate(date2));

        String date3 = "10/11/2020";
        Optional<LocalDate> correctDate3 = Optional.of(LocalDate.of(year, month2, dayOfMonth));
        assertEquals(correctDate3, task.parseDate(date3));

        String date4 = "1/1/2020";
        Optional<LocalDate> correctDate4 = Optional.of(LocalDate.of(year, 1, 1));
        assertEquals(correctDate4, task.parseDate(date4));

        String date5 = "tomorrow";
        Optional<LocalDate> correctDate5 = Optional.of(LocalDate.now().plusDays(1));
        assertEquals(correctDate5, task.parseDate(date5));

        String date6 = "today";
        Optional<LocalDate> correctDate6 = Optional.of(LocalDate.now());
        assertEquals(correctDate6, task.parseDate(date6));

        String date7 = "yesterday";
        Optional<LocalDate> correctDate7 = Optional.of(LocalDate.now().minusDays(1));
        assertEquals(correctDate7, task.parseDate(date7));

        String date8 = "3 days ago";
        Optional<LocalDate> correctDate8 = Optional.of(LocalDate.now().minusDays(dayToSubtract));
        assertEquals(correctDate8, task.parseDate(date8));

        String date9 = "1 day ago";
        Optional<LocalDate> correctDate9 = Optional.of(LocalDate.now().minusDays(1));
        assertEquals(correctDate9, task.parseDate(date9));

        String date10 = "asa";
        Optional<LocalDate> correctDate10 = Optional.empty();
        assertEquals(correctDate10, task.parseDate(date10));
    }
}
