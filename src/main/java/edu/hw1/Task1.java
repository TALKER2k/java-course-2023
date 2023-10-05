package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("checkstyle:RegexpSingleline")
public final class Task1 {
    private Task1() {}

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("checkstyle:UncommentedMain")
    public static void main(String[] args) {
        LOGGER.info(minutesToSeconds("10:59"));
    }

    public static int minutesToSeconds(String time) {
        final int num = 60;
        int afterInt = Integer.parseInt(time.substring(time.indexOf(":") + 1));
        int beforeInt = Integer.parseInt(time.substring(0, time.indexOf(":")));
        if (afterInt >= num || afterInt < 0 || beforeInt < 0) {
            return -1;
        }
        return beforeInt * num + afterInt;
    }
}
