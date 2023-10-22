package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        int currentAttempts = 0;
        boolean connected = false;
        while (!connected) {
            Connection connection = manager.getConnection();
            if (currentAttempts++ == maxAttempts) {
                connection.execute(command);
                connected = true;

            } else {
                try {
                    connection.execute(command);
                    connected = true;
                } catch (ConnectionException ignored) {

                }
            }
        }

    }
}
