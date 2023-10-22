package edu.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    private static final int WIDTH_SIDE = 20;
    private static final int HEIGHT_SIDE = 10;
    private static final double AREA = 200.0;

    static Arguments[] rectangles() {
        return new Arguments[]{
                Arguments.of(new Task2.Rectangle()),
                Arguments.of(new Task2.Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Task2.Rectangle rect) {
        Task2.Rectangle resultRect = rect.setWidth(WIDTH_SIDE);
        resultRect = resultRect.setHeight(HEIGHT_SIDE);
        assertThat(resultRect.area()).isEqualTo(AREA);
    }
}
