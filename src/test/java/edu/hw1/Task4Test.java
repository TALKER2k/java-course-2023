package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void withEvenLengthTest() {
        String input = "123456";

        StringBuilder result = Task4.fixString(input);

        assertEquals("214365", result.toString());
    }

    @Test
    void withOddLengthTest() {
        String input = "badce";

        StringBuilder result = Task4.fixString(input);

        assertEquals("abcde", result.toString());
    }

    @Test
    void withSingleSymbolTest() {
        String input = "a";

        StringBuilder result = Task4.fixString(input);

        assertEquals("a", result.toString());
    }

    @Test
    void emptyStringTest() {
        String input = "";

        StringBuilder result = Task4.fixString(input);

        assertEquals("", result.toString());
    }
}
