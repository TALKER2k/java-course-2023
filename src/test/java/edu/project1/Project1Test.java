package edu.project1;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {
    private static final String RESULT_LOSER = "You lost! :(";
    private static final String RESULT_WINNER = "You won! :)";
    private static final String WORD_FOR_TEST = "hello";

    @Test
    void runWinnerTest() {
        final int maxAttempts = 5;
        final int userAttempts = 0;
        ConsoleHangman consoleHangman = new ConsoleHangman();
        Session session = new Session(WORD_FOR_TEST, null, maxAttempts,
                new GuessResult(userAttempts, ""));
        String input = "h\ne\nl\no\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        consoleHangman.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_WINNER);
    }

    @Test
    void runLoserTest() {
        final int maxAttempts = 5;
        final int userAttempts = 0;
        ConsoleHangman consoleHangman = new ConsoleHangman();
        Session session = new Session(WORD_FOR_TEST, null, maxAttempts,
                new GuessResult(userAttempts, ""));
        String input = "h\ne\na\nd\no\nd\nd\nd\nd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        consoleHangman.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_LOSER);
        assertThat(session.getUserResult().getUserAttempts())
                .isEqualTo(maxAttempts);
    }

    @Test
    void notCorrectWordTest() {
        final int maxAttempts = 5;
        final int userAttempts = 0;
        ConsoleHangman consoleHangman = new ConsoleHangman();
        Session session = new Session("h", null, maxAttempts,
                new GuessResult(userAttempts, ""));

        consoleHangman.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo("");
    }

    @Test
    void largeStringInputWinnerTest() {
        final int maxAttempts = 5;
        final int userAttempts = 0;
        ConsoleHangman consoleHangman = new ConsoleHangman();
        Session session = new Session(WORD_FOR_TEST, null, maxAttempts,
                new GuessResult(userAttempts, ""));
        String input = "h\ne\nddd\ndd\no\nl\nl\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        consoleHangman.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_WINNER);
    }

    @Test
    void largeStringLoserTest() {
        ConsoleHangman consoleHangman = new ConsoleHangman();
        final int maxAttempts = 5;
        final int userAttempts = 0;
        Session session = new Session(WORD_FOR_TEST, null, maxAttempts,
                new GuessResult(userAttempts, ""));
        String input = "h\ne\nddd\ndd\nl\nl\nd\nd\nd\nd\nd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        consoleHangman.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_LOSER);
    }
}
