package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {
    private Task1() {}

    private static final Logger LOGGER = LogManager.getLogger();

    public static int minutesToSeconds(String time) {
        if (time == null) {
            LOGGER.info("Time is NULL!");
            return -1;
        }
        if (time.isEmpty()) {
            return -1;
        }
        final int maxSeconds = 60;
        int afterInt = Integer.parseInt(time.substring(time.indexOf(":") + 1));
        int beforeInt = Integer.parseInt(time.substring(0, time.indexOf(":")));
        if (afterInt >= maxSeconds || afterInt < 0 || beforeInt < 0) {
            return -1;
        }
        return beforeInt * maxSeconds + afterInt;
    }
}
