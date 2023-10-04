package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task0 {
    private Task0() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Главный метод, который запускает приложение.
     *
     * @param args Аргументы командной строки.
     */
    @SuppressWarnings("checkstyle:UncommentedMain")
    public static void main(String[] args) {
        LOGGER.info("Привет, мир!");
    }
}
