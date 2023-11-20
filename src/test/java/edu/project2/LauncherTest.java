package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LauncherTest {
    private Launcher launcher;
    private static final int SLEEP_TIME = 1;
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeEach
    void initLauncher() {
        launcher = new Launcher();
    }

    @Test
    void runLauncherTest() throws InterruptedException {
        Thread thread = new Thread(launcher::run);
        thread.start();
        thread.join(SLEEP_TIME);
        if (thread.isAlive()) {
            LOGGER.info("Method run worked, but stopped!");
        }
    }
}
