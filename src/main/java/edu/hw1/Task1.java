package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {
    private Task1() {}

    private static final Logger LOGGER = LogManager.getLogger();

    public static int minutesToSeconds(String time) {
        try {
            if (time == null) {
                throw new NullPointerException("String is NULL!");
            }
            if (time.isEmpty()) {
                return -1;
            }
        } catch (NullPointerException e) {
            LOGGER.info(e.getMessage());
            return -1;
        }
        final int num = 60;
        int afterInt = Integer.parseInt(time.substring(time.indexOf(":") + 1));
        int beforeInt = Integer.parseInt(time.substring(0, time.indexOf(":")));
        if (afterInt >= num || afterInt < 0 || beforeInt < 0) {
            return -1;
        }
        return beforeInt * num + afterInt;
    }
}
