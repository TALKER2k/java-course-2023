package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    public void testThirdSymbolIsZero() {
        Task7 task = new Task7();

        String string1 = "01011";
        assertTrue(task.thirdSymbolIsZero(string1));

        String string2 = "001000";
        assertFalse(task.thirdSymbolIsZero(string2));

        String string3 = "00";
        assertFalse(task.thirdSymbolIsZero(string3));
    }

    @Test
    public void testHaveSameStartAndEnd() {
        Task7 task = new Task7();

        String string1 = "1010101";
        assertTrue(task.haveSameStartAndEnd(string1));

        String string2 = "101010110";
        assertFalse(task.haveSameStartAndEnd(string2));
    }

    @Test
    public void testHaveLengthInRange13() {
        Task7 task = new Task7();

        String string1 = "111";
        assertTrue(task.haveLengthInRange13(string1));

        String string2 = "10001";
        assertFalse(task.haveLengthInRange13(string2));
    }
}
