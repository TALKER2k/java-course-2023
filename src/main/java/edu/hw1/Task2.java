package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Task2 {
    private Task2() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("checkstyle:UncommentedMain")
    public static void main(String[] args) {
        final int num = 4666;
        LOGGER.info(countDigits(num));
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static int countDigits(int number) {
        int temp = number;
        int count = 0;
        if (temp == 0) {
            return 1;
        }
        while (Math.abs(temp) > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }
}
