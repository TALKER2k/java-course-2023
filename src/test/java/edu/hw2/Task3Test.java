package edu.hw2;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.impl.DefaultConnectionManager;
import edu.hw2.Task3.impl.FaultyConnection;
import edu.hw2.Task3.impl.FaultyConnectionManager;
import edu.hw2.Task3.impl.PopularCommandExecutor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    void checkDefaultConnectionManagerGetConnection() {
        ConnectionManager connectionManager = new DefaultConnectionManager();

        Connection connection = connectionManager.getConnection();

        assertThat(connection).isInstanceOf(Connection.class);
    }

    @Test
    void checkFaultyConnectionManagerGetConnection() {
        ConnectionManager connectionManager = new FaultyConnectionManager();

        Connection connection = connectionManager.getConnection();

        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @Test
    void checkPopularCommandExecutor() {
        ConnectionManager manager = new FaultyConnectionManager();
        final int maxAttempts = 3;
        Connection connection = manager.getConnection();

        PopularCommandExecutor executor = new PopularCommandExecutor(manager, maxAttempts);
        executor.updatePackages();

        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }
}
