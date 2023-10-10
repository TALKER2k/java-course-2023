package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        LOGGER.info("Hello and welcome!");
        for (int i = 0; i <= 2; i++) {
            LOGGER.info("i = {}", i);
        }
    }
}
