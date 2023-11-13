package edu.hw5;

public class Task8 {

    // Нечетной длины
    public boolean check0(String line) {
        return line.matches("[01](?:[01]{2})*");
    }

    // Начинается с 0 и имеет нечетную длину,
    // или начинается с 1 и имеет четную длину
    public boolean check1(String line) {
        return line.matches("0(?:[01]{2})*") || line.matches("1[01](?:[01]{2})*");
    }

    // Каждый нечетный символ равен 1
    public boolean check2(String line) {
        return line.matches("(?:1[1|\\w]?)+");
    }

    // Нет последовательных 1
    public boolean check3(String line) {
        return line.matches("^(?!.*11).*$");
    }
}
