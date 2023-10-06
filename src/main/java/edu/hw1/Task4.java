package edu.hw1;

public final class Task4 {
    private Task4() {
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
