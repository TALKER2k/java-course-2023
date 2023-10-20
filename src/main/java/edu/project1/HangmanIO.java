package edu.project1;

import java.util.Scanner;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
public class HangmanIO {

    private final Scanner scanner;

    private static final Logger LOGGER = LogManager.getLogger();

    public HangmanIO() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        LOGGER.info(message);
    }

    public char[] charInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() == 1 || "quit".equals(input)) {
                return input.toCharArray();
            } else {
                displayMessage("Not correct! Try again!");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
