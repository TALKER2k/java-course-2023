package edu.hw2.Task3.impl;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;

public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
