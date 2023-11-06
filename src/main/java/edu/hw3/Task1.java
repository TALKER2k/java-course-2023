package edu.hw3;

public final class Task1 {
    private Task1() {}

    public static StringBuilder encodeAtbash(String str) {
        StringBuilder encodingStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                encodingStr.append((char) ('z' - str.charAt(i) + 'a'));
            }  else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                encodingStr.append((char) ('Z' - str.charAt(i) + 'A'));
            } else {
                encodingStr.append(str.charAt(i));
            }
        }

        return encodingStr;
    }
}
