package edu.hw1;

public final class Task2 {
    private Task2() {
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
