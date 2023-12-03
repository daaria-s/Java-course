package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 12345;
    private final int maxConnections;

    public Server(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void createServer() {

        ExecutorService executorService = Executors.newFixedThreadPool(maxConnections);

        try (
            ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection accepted");

                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
