package edu.project1;

import java.util.Scanner;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
public class HangmanIO {

    private final Scanner scanner;

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String EXIT_GAME = "quit";

    public HangmanIO() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        LOGGER.info(message);
    }

    public char[] charInputAndChecks(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (EXIT_GAME.equals(input)) {
                throw new IllegalArgumentException("You say \"quit\" and left the game!");
            } else if (input.length() == 1) {
                return input.toLowerCase().toCharArray();
            } else {
                displayMessage("Not correct! Try again!");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
