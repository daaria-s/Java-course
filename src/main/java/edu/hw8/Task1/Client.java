package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;


    public void createClient(InputStream inputStream, PrintStream printStream) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter writer = new PrintWriter(printStream, true);
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            writer.println("Connected to the server. Type 'exit' to close the connection.");

            String userInput;
            while (true) {
                userInput = reader.readLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                serverWriter.println(userInput);

                String response = serverReader.readLine();
                writer.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
