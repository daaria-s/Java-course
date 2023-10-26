package edu.hw2;

import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnection;
import edu.hw2.task3.FaultyConnectionManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    @Test
    void FaultyConnectionManagerTest() {
        FaultyConnectionManager manager = new FaultyConnectionManager();
        FaultyConnection connection = new FaultyConnection();
        for (int i = 0; i < 100; i++) {
            assertEquals(connection.getClass(), manager.getConnection().getClass());
        }
    }

    @Test
    void DefaultConnectionManagerTest() {
        DefaultConnectionManager manager = new DefaultConnectionManager();
        FaultyConnection connection = new FaultyConnection();
        int faultConnections = 0;
        for (int i = 0; i < 100; i++) {
            if (manager.getConnection().getClass() == connection.getClass()) {
                faultConnections++;
            }
        }
        assertTrue(faultConnections < 100);
        assertTrue(faultConnections > 0);
    }
}
