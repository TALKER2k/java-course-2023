package edu.hw2.Task3.impl;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    Random random = new Random();

    @Override
    public Connection getConnection() {
        if (random.nextBoolean()) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
