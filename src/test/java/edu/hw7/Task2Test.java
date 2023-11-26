package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    void factorialTest() {
        final int number = 10;
        final int resultNumber = 3_628_800;

        Task2 task = new Task2();

        long result = task.factorial(number);

        assertThat(result).isEqualTo(resultNumber);
    }
}
