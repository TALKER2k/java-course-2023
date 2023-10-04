package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task4 {
    private Task4() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("checkstyle:UncommentedMain")
    public static void main(String[] args) {
        LOGGER.info(fixString("a"));
    }

    public static StringBuilder fixString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i += 2) {
            stringBuilder.append(input.charAt(i + 1));
            stringBuilder.append(input.charAt(i));
        }
        if (input.length() != stringBuilder.length()) {
            stringBuilder.append(input.charAt(input.length() - 1));
        }
        return stringBuilder;
    }
}
