package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    void arrayWhenIsEmptyTest() {
        int[] a1 = {};
        int[] a2 = {};

        boolean result = Task3.isNestable(a1, a2);

        assertFalse(result);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void arrayWhenNestableTest() {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{0, 6};

        boolean result = Task3.isNestable(a1, a2);

        assertTrue(result);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void arrayWhenNotNestableTest() {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{2, 3};

        boolean result = Task3.isNestable(a1, a2);

        assertFalse(result);
    }
}
