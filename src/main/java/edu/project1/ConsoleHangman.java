package edu.project1;

import java.util.Random;
import static edu.project1.Dictionary.WORDS_FOR_SUCCESSFUL_GUESSING;

public final class ConsoleHangman {
    private static final int MAX_ATTEMPTS = 5;
    public static final String RESULT_LOSER = "You lost! :(";
    public static final String RESULT_WINNER = "You won! :)";
    Session session;
    HangmanIO hangmanIO;

    public void run() {
        session = new Session(MAX_ATTEMPTS);
        hangmanIO = new HangmanIO();
        hangmanIO.displayMessage("Welcome to the game Hangman");
        while (session.isAnswerNotGuess()) {
            hangmanIO.displayMessage("You can say \"quit\" to given up");
            hangmanIO.displayMessage("The word: " + session.getEncryptedAnswer());
            hangmanIO.displayMessage("Guess a letter:");
            session.setUserAnswer(hangmanIO.charInputAndChecks(hangmanIO.getScanner()));

            int countGuess = session.tryGuess(session.getUserAnswer()[0]);

            checkUserGuess(countGuess);

            if (checkResult()) {
                break;
            }
        }
        hangmanIO.close();
    }

    private void checkUserGuess(int countGuess) {
        if (countGuess == 0) {
            session.setUserAttempts(session.getUserAttempts() + 1);
            hangmanIO.displayMessage("Missed, mistake "
                    + session.getUserAttempts()
                    + " out of "
                    + session.getMaxAttempts() + ".");
        } else {
            Random random = new Random();
            hangmanIO.displayMessage(WORDS_FOR_SUCCESSFUL_GUESSING
                    .get(random.nextInt(WORDS_FOR_SUCCESSFUL_GUESSING.size())));
        }
    }

    private boolean checkResult() {
        if (session.isWin()) {
            hangmanIO.displayMessage(new Win(RESULT_WINNER).text());
            return true;
        } else if (session.isDefeat()) {
            hangmanIO.displayMessage("The hidden word was - " + session.getAnswer());
            hangmanIO.displayMessage(new Defeat(RESULT_LOSER).text());
            return  true;
        } else {
            return false;
        }
    }

    public record Win(String text) {}

    public record Defeat(String text) {}
}
