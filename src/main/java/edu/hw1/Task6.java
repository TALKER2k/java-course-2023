package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task6 {
    private Task6() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("checkstyle:UncommentedMain")
    public static void main(String[] args) {
        final int number = 6554;
        LOGGER.info(countK(number));
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static int countK(int number) {
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
