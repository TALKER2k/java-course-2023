package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsoleHangmanTest {
    private static final int SLEEP_TIME = 3000;
    private static final Logger LOGGER = LogManager.getLogger();
    ConsoleHangman consoleHangman;

    @BeforeEach
    void initConsole() {
        consoleHangman = new ConsoleHangman();
    }

    @Test
    void runGameTest() throws InterruptedException {
        Thread thread = new Thread(consoleHangman::run);
        thread.start();
        thread.join(SLEEP_TIME);
        if (thread.isAlive()) {
            LOGGER.info("Method run worked, but stopped!");
        }
    }
}
