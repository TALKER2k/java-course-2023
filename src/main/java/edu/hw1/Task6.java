package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static int countK(int number) {
        if (number < 1000 || number > 9999) {
            return 0;
        }
        final int kaprekar = 6174;
        if (number == kaprekar) {
            return 0;
        }
        return 1 + countK(descendingMinusAscendingNumbers(number));
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    private static int descendingMinusAscendingNumbers(int number) {
        StringBuilder result = new StringBuilder();
        String numberStr = Integer.toString(number);
        char[] charArray = numberStr.toCharArray();
        Arrays.sort(charArray);
        for (var num : charArray) {
            result.append(num);
        }
        return Integer.parseInt(String.valueOf(result.reverse())) - Integer.parseInt(String.valueOf(result.reverse()));
    }
}
