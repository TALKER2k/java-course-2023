package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task3 {
    private Task3() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean isNestable(int[] a1, int[] a2) {
        try {
            if (a1 == null || a2 == null) {
                throw new NullPointerException("Array is NULL!");
            }
        } catch (NullPointerException e) {
            LOGGER.info("Exeption " + e.getMessage());
            return false;
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (a1.length == 0 || a2.length == 0) {
            return false;
        } else {
            return (a1[0] > a2[0] && a1[a1.length - 1] < a2[a2.length - 1]);
        }
    }
}
