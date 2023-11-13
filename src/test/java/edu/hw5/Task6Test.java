package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {

    @Test
    public void testContainsSubsequence() {
        Task6 task = new Task6();

        String superString1 = "placeholder";
        String subString1 = "hol";
        assertTrue(task.containsSubsequence(superString1, subString1));

        String superString2 = "apple";
        String subSequence2 = "ape";
        assertTrue(task.contains(superString2, subSequence2));

        String superString3 = "twenty";
        String subString3 = "cc";
        assertFalse(task.containsSubsequence(superString3, subString3));
    }
}
