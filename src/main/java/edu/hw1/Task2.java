package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Task2 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info(countDigits(4666));
    }

    public static int countDigits(int number) {
        int count = 0;
        if (number == 0) {
            return 1;
        }
        while (Math.abs(number) > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
