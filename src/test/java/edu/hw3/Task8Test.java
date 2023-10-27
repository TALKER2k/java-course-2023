package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("checkstyle:MagicNumber")
public class Task8Test<T> {
    static Stream<Arguments> backwardIteratorCase() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 1)),
                Arguments.of(List.of(4, 5, 3, 2, 1), List.of(1, 2, 3, 5, 4)),
                Arguments.of(List.of("A", "B", "C"), List.of("C", "B", "A")),
                Arguments.of(List.of('a', 'b', 'c'), List.of('c', 'b', 'a'))
        );
    }

    @ParameterizedTest
    @MethodSource("backwardIteratorCase")
    void backwardIterator(List<T> input, List<T> expected) {
        Iterator<T> backwardIterator = new BackwardIterator<>(input);
        List<T> resultList = new ArrayList<>();

        while (backwardIterator.hasNext()) {
            resultList.add(backwardIterator.next());
        }

        assertThat(resultList).isEqualTo(expected);
    }
}
