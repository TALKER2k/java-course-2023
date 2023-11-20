package edu.hw5;

import edu.hw5.Task3.Task3;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    private static final Task3 DATE_PARSER = new Task3();

    @ParameterizedTest
    @MethodSource("dateProvider")
    public void testParseDate(String input, Optional<LocalDate> expectedDate) {
        Optional<LocalDate> result = DATE_PARSER.parseDate(input);
        assertThat(result).isEqualTo(expectedDate);
    }

    private static Stream<Arguments> dateProvider() {
        final int year1 = 2020;
        final int year2 = 1976;
        final int year3 = 2234;
        final int month1 = 10;
        final int dayOfMonth1 = 10;
        final int dayOfMonth2 = 3;
        return Stream.of(
                Arguments.of("2020-10-10", Optional.of(LocalDate.of(year1, month1, dayOfMonth1))),
                Arguments.of("1/3/1976", Optional.of(LocalDate.of(year2, 1, dayOfMonth2))),
                Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
                Arguments.of("today", Optional.of(LocalDate.now())),
                Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
                Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
                Arguments.of("2234 days ago", Optional.of(LocalDate.now().minusDays(year3))),
                Arguments.of("invalid", Optional.empty())
        );
    }
}
