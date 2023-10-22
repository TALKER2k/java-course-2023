package edu.hw2;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.impl.DefaultConnectionManager;
import edu.hw2.Task3.impl.FaultyConnection;
import edu.hw2.Task3.impl.FaultyConnectionManager;
import edu.hw2.Task3.impl.PopularCommandExecutor;
import edu.hw2.Task3.impl.StableConnection;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testConnectionExceptionMessage() {
        String expectedMessage = "Connection Exception";
        ConnectionException exception = new ConnectionException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testExecute() {
        StableConnection connection = new StableConnection();

        connection.execute("apt update && apt upgrade -y");

        assertThat(connection).isInstanceOf(StableConnection.class);
    }
}
