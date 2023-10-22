package edu.hw2.Task3.impl;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) throws ConnectionException {
        LOGGER.info("Execute command: " + command + " is FaultyConnection");
        if (throwConnectionException()) {
            throw new ConnectionException();
        }
    }

    private boolean throwConnectionException() {
        final double probability = 0.10;
        return Math.random() < probability;
    }

    @Override
    public void close() {}
}
