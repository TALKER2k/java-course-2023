package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    public void testValidateCarPlate() {
        Task5 task = new Task5();

        String string1 = "A111AA111";
        assertTrue(task.validateCarPlate(string1));

        String string2 = "000aA111";
        assertFalse(task.validateCarPlate(string2));
    }
}
