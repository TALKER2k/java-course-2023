package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void whoCallingTest() {
        Task4.CallingInfo callingInfo;

        callingInfo = Task4.callingInfo();

        assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(callingInfo.methodName()).isEqualTo("whoCallingTest");
    }
}
