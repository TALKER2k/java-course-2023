package edu.hw3;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test  {
    static Stream<Arguments> clusterizeCases() {
        final String bracket = "((()))";
        return Stream.of(
                Arguments.of("()()()", List.of("()", "()", "()")),
                Arguments.of(bracket, List.of(bracket)),
                Arguments.of("((()))(())()()(()())", List.of(bracket, "(())", "()", "()", "(()())")),
                Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))")),
                Arguments.of(null, List.of()),
                Arguments.of("", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("clusterizeCases")
    void clusterizeTest(String input, List<String> expectedOutput) {
        List<String> result = Task2.clusterize(input);

        assertThat(result).isEqualTo(expectedOutput);
    }
}
