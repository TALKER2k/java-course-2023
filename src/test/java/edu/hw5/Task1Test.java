package edu.hw5;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    public void testGetStringAverageDuration() {
        Task1 task = new Task1();

        List<String> records = List.of(
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );
        String correctStringAverageDuration = "3h 40m";

        String result = task.getStringAverageDuration(records);

        assertEquals(correctStringAverageDuration, result);
    }
}

