package edu.hw3;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test<T> {
    static Stream<Arguments> freqDictCase() {
        final String codeStr = "код";
        final String thisStr = "this";
        final String andStr = "and";
        final String thatStr = "that";
        final String bugStr = "bug";
        final int freqCodeStr = 3;
        return Stream.of(
                Arguments.of(List.of("a", "bb", "a", "bb"), Map.of("bb", 2, "a", 2)),
                Arguments.of(List.of(thisStr, andStr, thatStr, andStr), Map.of(thatStr, 1, andStr, 2, thisStr, 1)),
                Arguments.of(List.of(codeStr, codeStr, codeStr, bugStr), Map.of(codeStr, freqCodeStr, bugStr, 1)),
                Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("freqDictCase")
    void freqDictTest(List<T> input, Map<T, Integer> expectedOutput) {
        Map<T, Integer> freqResult;

        freqResult = Task3.freqDict(input);

        assertThat(freqResult).isEqualTo(expectedOutput);
    }
}
