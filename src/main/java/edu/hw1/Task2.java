package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int temp = number;
        int count = 0;
        while (Math.abs(temp) > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }
}
