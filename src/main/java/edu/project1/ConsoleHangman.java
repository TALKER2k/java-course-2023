package edu.project1;

import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

class ConsoleHangman implements Dictionary {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String[] WORDS_FOR_GUESS = {"black", "hello", "banana", "pineapple", "pigeon"};

    private static final String[] WORDS_FOR_SUCCESSFUL_GUESSING = {"Hit", "Great", "Nice", "Well done"};

    public @NotNull String randomWord(String[] stringsArray) {
        return stringsArray[new Random().nextInt(stringsArray.length)];
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public void run(Session session) {
        if (session.getAnswer().length() >= 50 || session.getAnswer().length() == 1) {
            return;
        }
        if ("".equals(session.getAnswer())) {
            session.setAnswer(randomWord(WORDS_FOR_GUESS));
        }
        LOGGER.info("Welcome to the game Hangman");
        StringBuilder encryptedWord = new StringBuilder(session.getAnswer().replaceAll("[a-zA-Z]", "*"));
        Scanner scanner = new Scanner(System.in);
        while (session.getMaxAttempts() - session.getUserResult().getUserAttempts() > 0
                && encryptedWord.indexOf("*") != -1) {
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
                session.getUserResult().setUserAttempts(session.getUserResult().getUserAttempts() + 1);
                LOGGER.info("Missed, mistake "
                        + session.getUserResult().getUserAttempts()
                        + " out of "
                        + session.getMaxAttempts() + ".");
            }
        }
        LOGGER.info("The hidden word was - " + session.getAnswer());
        if (encryptedWord.indexOf("*") == -1) {
            String resultMessage = "You won! :)";
            session.getUserResult().setResultMessage(resultMessage);
            LOGGER.info(new Win(resultMessage).text);
        } else {
            String resultMessage = "You lost! :(";
            session.getUserResult().setResultMessage(resultMessage);
            LOGGER.info(new Defeat(resultMessage).text);
        }
    }

    public record Win(String text) {}

    public record Defeat(String text) {}
}
