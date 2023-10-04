package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info(isPalindromeDescendant(123312));
        LOGGER.info(isPalindromeDescendant(431));
        LOGGER.info(isPalindromeDescendant(0));
    }

    public static boolean isPalindromeDescendant(int number) {
        while (number >= 10) {
            if (isPalindrome(number)) {
                return true;
            }
            int sum = 0;
            number = reverseNumber(number);
            while (number > 0) {
                int num = number % 10 + number / 10 % 10;
                sum = sum * 10 + num;
                number /= 100;
            }
            number = sum;
        }
        return false;
    }

    public static boolean isPalindrome(int number) {
        return number == reverseNumber(number);
    }

    public static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }
}