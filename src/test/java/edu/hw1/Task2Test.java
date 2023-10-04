package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void positiveNumberTest() {
        int number1 = 4060;
        int number2 = 544;

        int resultCount1 = Task2.countDigits(number1);
        int resultCount2 = Task2.countDigits(number2);

        assertThat(resultCount1).isEqualTo(4);
        assertThat(resultCount2).isEqualTo(3);
    }

    @Test
    void negativeNumberTest() {
        int number1 = -4000;
        int number2 = -504;

        int resultCount1 = Task2.countDigits(number1);
        int resultCount2 = Task2.countDigits(number2);

        assertThat(resultCount1).isEqualTo(4);
        assertThat(resultCount2).isEqualTo(3);
    }

    @Test
    void zeroNumberTest() {
        int number = 0;

        int resultCount = Task2.countDigits(number);

        assertThat(resultCount).isEqualTo(1);
    }
}
