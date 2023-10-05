package edu.hw1;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @SuppressWarnings("checkstyle:MagicNumber")
    @Test
    void countKTest() {
        final int number1 = 6621;
        final int number2 = 6554;
        final int number3 = 1234;

        final int result1 = Task6.countK(number1);
        final int result2 = Task6.countK(number2);
        final int result3 = Task6.countK(number3);

        assertThat(result1).isEqualTo(5);
        assertThat(result2).isEqualTo(4);
        assertThat(result3).isEqualTo(3);
    }
}
