package edu.hw2.Task3.impl;

import edu.hw2.Task3.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        LOGGER.info("Execute command: " + command + " is StableConnection");
    }

    @Override
    public void close() throws Exception {

    }
}
