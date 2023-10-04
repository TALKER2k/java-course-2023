package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info(minutesToSeconds("10:59"));
    }

    public static int minutesToSeconds(String time) {
        int afterInt = Integer.parseInt(time.substring(time.indexOf(":") + 1));
        int beforeInt = Integer.parseInt(time.substring(0, time.indexOf(":")));
        if (afterInt >= 60 || afterInt < 0 || beforeInt < 0)
            return -1;
        return beforeInt * 60 + afterInt;
    }
}
