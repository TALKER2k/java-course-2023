package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void testIsNumberPalindrome() {
        int number1 = 121;
        int number2 = 1331;
        int number3 = 12345;
        int number4 = 123;
        int number5 = 11;

        boolean result1 = Task5.isPalindromeDescendant(number1);
        boolean result2 = Task5.isPalindromeDescendant(number2);
        boolean result3 = Task5.isPalindromeDescendant(number3);
        boolean result4 = Task5.isPalindromeDescendant(number4);
        boolean result5 = Task5.isPalindromeDescendant(number5);

        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertTrue(result5);
    }

    @Test
    void testHasPalindromeDescendant() {
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
        assertTrue(Task5.isPalindromeDescendant(11211230));
    }
}
