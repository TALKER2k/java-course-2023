package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void rotateLeftTest() {
        int number1 = 16;
        int number2 = 17;
        int number3 = 32432;
        int shift1 = 1;
        int shift2 = 2;
        int shift3 = 2;

        int result1 = Task7.rotateLeft(number1, shift1);
        int result2 = Task7.rotateLeft(number2, shift2);
        int result3 = Task7.rotateLeft(number3, shift3);

        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(6);
        assertThat(result3).isEqualTo(31427);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void rotateRightTest() {
        int number1 = 8;
        int number2 = 0;
        int number3 = 3242;
        int shift1 = 1;
        int shift2 = 1;
        int shift3 = 2;

        int result1 = Task7.rotateRight(number1, shift1);
        int result2 = Task7.rotateRight(number2, shift2);
        int result3 = Task7.rotateRight(number3, shift3);

        assertThat(result1).isEqualTo(4);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(2858);
    }
}
