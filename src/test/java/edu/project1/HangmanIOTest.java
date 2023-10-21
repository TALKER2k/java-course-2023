package edu.project1;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static edu.project1.HangmanIO.EXIT_GAME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanIOTest {
    HangmanIO hangmanIO;

    @BeforeEach
    void initHangmanIO() {
        hangmanIO = new HangmanIO();
    }

    @Test
    void checkInputTest() {
        String input = "h";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        char[] inputs = hangmanIO.charInputAndChecks(new Scanner(System.in));
        assertThat(inputs).contains('h');
    }

    @Test
    void checkInputExitTest() {
        System.setIn(new ByteArrayInputStream(EXIT_GAME.getBytes()));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                hangmanIO.charInputAndChecks(new Scanner(System.in)));
        assertThat(exception.getMessage()).isEqualTo("You say \"quit\" and left the game!");
    }
}
