package edu.project1;

import static edu.project1.Dictionary.WORDS_FOR_GUESS;
import static edu.project1.Dictionary.WORDS_FOR_SUCCESSFUL_GUESSING;

final class ConsoleHangman {
    private static final int MAX_LENGTH = 50;

    public void run(Session session) {
        HangmanIO hangmanIO = new HangmanIO();
        if (session.getAnswer().length() >= MAX_LENGTH || session.getAnswer().length() == 1) {
            hangmanIO.displayMessage("Too big a word!");
            return;
        }

        if (session.getAnswer().isEmpty()) {
            session.setAnswer(ListUtils.randomWord(WORDS_FOR_GUESS));
        }

        hangmanIO.displayMessage("Welcome to the game Hangman");
        StringBuilder encryptedWord = new StringBuilder(session.getAnswer());
        encryptedAnswer(encryptedWord);

        while (session.isActiveSession() && encryptedWord.indexOf("*") != -1) {
            hangmanIO.displayMessage("You can say \"quit\" to given up");
            hangmanIO.displayMessage("The word: " + encryptedWord);
            hangmanIO.displayMessage("Guess a letter:");
            char[] charInput = hangmanIO.charInput(hangmanIO.getScanner());
            if ("quit".equals(String.valueOf(charInput))) {
                hangmanIO.displayMessage("You've given up.");
                break;
            }

            session.setUserAnswer(charInput);
            openWordForUser(session, encryptedWord);
        }

        hangmanIO.displayMessage("The hidden word was - " + session.getAnswer());

        if (encryptedWord.indexOf("*") == -1) {
            String resultMessage = "You won! :)";
            session.getUserResult().setResultMessage(resultMessage);
            hangmanIO.displayMessage(new Win(resultMessage).text());
        } else {
            String resultMessage = "You lost! :(";
            session.getUserResult().setResultMessage(resultMessage);
            hangmanIO.displayMessage(new Defeat(resultMessage).text());
        }
        hangmanIO.close();
    }

    public void encryptedAnswer(StringBuilder answer) {
        for (int i = 0; i < answer.length(); i++) {
            answer.setCharAt(i, '*');
        }
    }

    public void openWordForUser(Session session, StringBuilder encryptedWord) {
        HangmanIO hangmanIO = new HangmanIO();
        if (session.getAnswer().contains(String.valueOf(session.getUserAnswer()))) {
            hangmanIO.displayMessage(ListUtils.randomWord(WORDS_FOR_SUCCESSFUL_GUESSING));
            for (int i = 0; i < encryptedWord.length(); i++) {
                if (session.getAnswer().charAt(i) == session.getUserAnswer()[0]) {
                    encryptedWord.setCharAt(i, session.getAnswer().charAt(i));
                }
            }
        } else {
            session.getUserResult().setUserAttempts(session.getUserResult().getUserAttempts() + 1);
            hangmanIO.displayMessage("Missed, mistake "
                    + session.getUserResult().getUserAttempts()
                    + " out of "
                    + session.getMaxAttempts() + ".");
        }
    }
}
