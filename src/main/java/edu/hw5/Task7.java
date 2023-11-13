package edu.hw5;

public class Task7 {

    public boolean thirdSymbolIsZero(String line) {
        return line.matches("[01]{2}0[0|1]*");
    }

    public boolean haveSameStartAndEnd(String line) {
        return line.matches("^([0|1]).*\\1");
    }

    public boolean haveLengthInRange13(String line) {
        return line.matches("[01]{1,3}");
    }
}
