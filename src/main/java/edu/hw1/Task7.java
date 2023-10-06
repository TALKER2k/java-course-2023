package edu.hw1;

public final class Task7 {
    private Task7() {}

    public static int rotateRight(int n, int shift) {
        String numberString = Integer.toBinaryString(n);
        for (int i = 0; i < shift; i++) {
            numberString = numberString.substring(numberString.length() - 1)
                    + numberString.substring(0, numberString.length() - 1);
        }
        return Integer.parseInt(numberString, 2);
    }

    public static int rotateLeft(int n, int shift) {
        String numberString = Integer.toBinaryString(n);
        for (int i = 0; i < shift; i++) {
            numberString = numberString.substring(1)
                    + numberString.charAt(0);
        }
        return Integer.parseInt(numberString, 2);
    }
}
