package edu.project1;

import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

class ConsoleHangman implements Dictionary {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String[] WORDS_FOR_GUESS = {"black", "hello", "banana", "pineapple", "pigeon"};

    private static final String[] WORDS_FOR_SUCCESSFUL_GUESSING = {"Hit", "Great", "Nice", "Well done"};

    public @NotNull String randomWord(String[] stringsArray) {
        return stringsArray[new Random().nextInt(stringsArray.length)];
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public void run() {
        Session session = new Session(randomWord(WORDS_FOR_GUESS), null, 5, 0);
        LOGGER.info("Welcome to the game Hangman");
        StringBuilder encryptedWord = new StringBuilder(session.getAnswer().replaceAll("[a-zA-Z]", "*"));
        Scanner scanner = new Scanner(System.in);
        while (session.getMaxAttempts() - session.getUserAttempts() > 0 && encryptedWord.indexOf("*") != -1) {
            LOGGER.info("You can say \"quit\" to given up");
            LOGGER.info("The word: " + encryptedWord);
            LOGGER.info("Guess a letter:");
            char[] charInput = scanner.nextLine().toCharArray();
            if (charInput.length != 1) {
                if ("quit".equals(String.valueOf(charInput))) {
                    LOGGER.info("You've given up.");
                    break;
                }
                LOGGER.info("Not correct! Try again!");
                continue;
            } else {
                session.setUserAnswer(charInput);
            }
            if (session.getAnswer().contains(String.valueOf(session.getUserAnswer()))) {
                LOGGER.info(randomWord(WORDS_FOR_SUCCESSFUL_GUESSING));
                for (int i = 0; i < encryptedWord.length(); i++) {
                    if (session.getAnswer().charAt(i) == session.getUserAnswer()[0]) {
                        encryptedWord.setCharAt(i, session.getAnswer().charAt(i));
                    }
                }
            } else {
                session.setUserAttempts(session.getUserAttempts() + 1);
                LOGGER.info("Missed, mistake "
                        + session.getUserAttempts()
                        + " out of "
                        + session.getMaxAttempts() + ".");
            }
        }
        LOGGER.info("The hidden word was - " + session.getAnswer());
        if (encryptedWord.indexOf("*") == -1) {
            LOGGER.info(new Win("You won! :)").text);
        } else {
            LOGGER.info(new Defeat("You lost! :(").text);
        }
    }

    public record Win(String text) {}

    public record Defeat(String text) {}
}
