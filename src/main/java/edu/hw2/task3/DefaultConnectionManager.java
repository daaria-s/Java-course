package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        Random rn = new Random();
        if (rn.nextInt() % 2 == 0) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
