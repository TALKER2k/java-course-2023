package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionTest {
    Session session;

    @BeforeEach
    void initSession() {
        session = new Session();
    }

    @Test
    void isAnswerNotGuessTest() {
        assertNotEquals(session.getAnswer(), String.valueOf(session.getEncryptedAnswer()));
    }

    @Test
    void guessAttemptTest() {
        String answer = session.getAnswer();
        char letter = answer.charAt(0);
        int countGuess = 0;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter) {
                countGuess++;
            }
        }

        assertThat(session.tryGuess(letter)).isEqualTo(countGuess);
        assertThat(session.tryGuess('.')).isEqualTo(0);
    }

    @Test
    void checkWinGameTest() {
        String answer = session.getAnswer();
        StringBuilder encryptedAnswer = session.getEncryptedAnswer();
        char[] letters = answer.toCharArray();

        for (int i = 0; i < answer.length(); i++) {
            if (letters[i] == answer.charAt(i)) {
                encryptedAnswer.setCharAt(i, letters[i]);
            }
        }

        assertTrue(session.isWin());
    }

    @Test
    void checkDefeatGameTest() {
        String answer = session.getAnswer();
        StringBuilder encryptedAnswer = session.getEncryptedAnswer();
        char letter = answer.charAt(0);

        for (int i = 0; i < answer.length(); i++) {
            if (letter == answer.charAt(i)) {
                encryptedAnswer.setCharAt(i, letter);
            }
        }

        assertTrue(session.isDefeat());
    }
}
