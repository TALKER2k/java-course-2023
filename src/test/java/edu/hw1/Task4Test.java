package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void withEvenLengthTest() {
        String input = "123456";
        String input2 = "hTsii  s aimex dpus rtni.g";

        StringBuilder result = Task4.fixString(input);
        StringBuilder result2 = Task4.fixString(input2);

        assertEquals("214365", result.toString());
        assertEquals("This is a mixed up string.", result2.toString());
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
