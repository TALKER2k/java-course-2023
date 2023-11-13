package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    public void testCheck0() {
        Task8 task = new Task8();

        String string1 = "01234";
        assertTrue(task.check0(string1));

        String string2 = "0111";
        assertFalse(task.check0(string2));
    }

    @Test
    public void testCheck1() {
        Task8 task = new Task8();

        String string1 = "011";
        assertTrue(task.check1(string1));

        String string2 = "1101";
        assertTrue(task.check1(string2));

        String string3 = "000000";
        assertFalse(task.check1(string3));

        String string4 = "100";
        assertFalse(task.check1(string4));
    }

    @Test
    public void testCheck2() {
        Task8 task = new Task8();

        String string1 = "13141";
        assertTrue(task.check2(string1));

        String string2 = "1111";
        assertTrue(task.check2(string2));

        String string3 = "00000";
        assertFalse(task.check2(string3));
    }

    @Test
    public void testCheck3() {
        Task8 task = new Task8();

        String string1 = "12141";
        assertTrue(task.check3(string1));

        String string2 = "0000";
        assertTrue(task.check3(string2));

        String string3 = "125112";
        assertFalse(task.check3(string3));
    }
}
