package edu.project1;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static edu.project1.ConsoleHangman.RESULT_LOSER;
import static edu.project1.ConsoleHangman.RESULT_WINNER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {
    private static final String WORD_FOR_TEST = "hello";

    private static final ConsoleHangman CONSOLE_HANGMAN = new ConsoleHangman();

    private static final int MAX_ATTEMPTS = 5;
    private static final int USER_ATTEMPTS = 0;
    private Session session;

    @Test
    void runSessionTest() {
        session = new Session(WORD_FOR_TEST, null, MAX_ATTEMPTS,
                new GuessResult(USER_ATTEMPTS, ""));
    }

    @Test
    void runWinnerTest() {
        runSessionTest();
        String input = "h\ne\nl\no\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CONSOLE_HANGMAN.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_WINNER);
    }

    @Test
    void runLoserTest() {
        runSessionTest();
        String input = "h\ne\na\nd\no\nd\nd\nd\nd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CONSOLE_HANGMAN.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_LOSER);
        assertThat(session.getUserResult().getUserAttempts())
                .isEqualTo(MAX_ATTEMPTS);
    }

    @Test
    void notCorrectWordTest() {
        runSessionTest();
        session.setAnswer("a");
        CONSOLE_HANGMAN.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo("");
    }

    @Test
    void largeStringInputWinnerTest() {
        runSessionTest();
        String input = "h\ne\nddd\ndd\no\nl\nl\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CONSOLE_HANGMAN.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_WINNER);
    }

    @Test
    void largeStringLoserTest() {
        runSessionTest();
        String input = "h\ne\nddd\ndd\nl\nl\nd\nd\nd\nd\nd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        CONSOLE_HANGMAN.run(session);

        assertThat(session.getUserResult().getResultMessage())
                .isEqualTo(RESULT_LOSER);
    }
}
