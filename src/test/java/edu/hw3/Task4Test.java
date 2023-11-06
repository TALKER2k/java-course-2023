package edu.hw3;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @SuppressWarnings("checkstyle:MagicNumber")
    static Stream<Arguments> freqDictCase() {
        return Stream.of(
                Arguments.of(4, "IV"),
                Arguments.of(423, "CDXXIII"),
                Arguments.of(234, "CCXXXIV"),
                Arguments.of(3999, "MMMCMXCIX"),
                Arguments.of(3654, "MMMDCLIV"),
                Arguments.of(38, "XXXVIII"),
                Arguments.of(39, "XXXIX"),
                Arguments.of(859, "DCCCLIX")
        );
    }

    static Stream<Arguments> freqDictBadCase() {
        final int badNumber = 4500;
        return Stream.of(
                Arguments.of(-1, ""),
                Arguments.of(0, ""),
                Arguments.of(badNumber, "")
        );
    }

    @ParameterizedTest
    @MethodSource("freqDictCase")
    void freqDictTest(int input, String expectedOutput) {
        StringBuilder romanResult;

        romanResult = Task4.convertToRoman(input);

        assertThat(romanResult.toString()).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("freqDictBadCase")
    void freqDictBadTest(int input, String expectedOutput) {
        StringBuilder romanResult;

        romanResult = Task4.convertToRoman(input);

        assertThat(romanResult.toString()).isEqualTo(expectedOutput);
    }
}
