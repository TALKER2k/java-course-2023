package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task3 {
    private Task3() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings({"checkstyle:UncommentedMain", "checkstyle:MagicNumber"})
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{0, 6};
        LOGGER.info(isNestable(a1, a2));
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (a1.length == 0 || a2.length == 0) {
            return false;
        } else {
            return (a1[0] > a2[0] && a1[a1.length - 1] < a2[a2.length - 1]);
        }
    }
}
