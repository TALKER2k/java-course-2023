package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.count;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void incrementTest() throws InterruptedException {
        Task1 task = new Task1();
        final int iterations = 10_000;
        final int threadsNum = 5;
        final int count1 = iterations * threadsNum;

        task.increment(iterations, threadsNum);

        assertThat(count.intValue()).isEqualTo(count1);
    }
}
