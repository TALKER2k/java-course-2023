package edu.project1;

import java.io.ByteArrayInputStream;

public class Main {
    public static void main(String[] args) {
        final int maxAttempts = 5;
        final int userAttempts = 0;
        ConsoleHangman consoleHangman = new ConsoleHangman();
        Session session = new Session("", null, maxAttempts,
                new GuessResult(userAttempts, ""));
        consoleHangman.run(session);
    }
}
