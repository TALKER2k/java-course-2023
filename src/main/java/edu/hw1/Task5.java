package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static boolean isPalindromeDescendant(int number) {
        int temp = number;
        while (temp >= 10) {
            if (isPalindrome(temp)) {
                return true;
            }
            int sum = 0;
            temp = reverseNumber(temp);
            while (temp > 0) {
                int num = temp % 10 + temp / 10 % 10;
                sum = sum * 10 + num;
                temp /= 100;
            }
            temp = sum;
        }
        return false;
    }

    private static boolean isPalindrome(int number) {
        return number == reverseNumber(number);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static int reverseNumber(int number) {
        int temp = number;
        int reversedNumber = 0;
        while (temp > 0) {
            reversedNumber = reversedNumber * 10 + temp % 10;
            temp = temp / 10;
        }
        return reversedNumber;
    }
}
