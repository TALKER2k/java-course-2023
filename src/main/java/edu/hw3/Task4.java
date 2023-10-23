package edu.hw3;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("checkstyle:MagicNumber")
public final class Task4 {
    private Task4() {}

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MAX_NUMBER = 3999;

    public static final Map<Integer, String> ROMAN_NUMBERS = new LinkedHashMap<>();

    static {
        ROMAN_NUMBERS.put(1000, "M");
        ROMAN_NUMBERS.put(900, "CM");
        ROMAN_NUMBERS.put(500, "D");
        ROMAN_NUMBERS.put(400, "CD");
        ROMAN_NUMBERS.put(100, "C");
        ROMAN_NUMBERS.put(90, "XC");
        ROMAN_NUMBERS.put(50, "L");
        ROMAN_NUMBERS.put(40, "XL");
        ROMAN_NUMBERS.put(10, "X");
        ROMAN_NUMBERS.put(9, "IX");
        ROMAN_NUMBERS.put(5, "V");
        ROMAN_NUMBERS.put(4, "IV");
        ROMAN_NUMBERS.put(1, "I");
    }

    public static StringBuilder convertToRoman(int numberForRim) {
        if (numberForRim < 1 || numberForRim > MAX_NUMBER) {
            LOGGER.info("Incorrect number!");
            return new StringBuilder();
        }

        StringBuilder rimNumber = new StringBuilder();
        int numberForRimClone = numberForRim;

        for (int arabNumber: ROMAN_NUMBERS.keySet()) {
            while (numberForRimClone >= arabNumber) {
                rimNumber.append(ROMAN_NUMBERS.get(arabNumber));
                numberForRimClone -= arabNumber;
            }
        }

        return rimNumber;
    }
}
