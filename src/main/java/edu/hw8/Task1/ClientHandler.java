package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    Map<String, String> vocabulary = Map.of("личности", "Не переходи на личности там, где их нет",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления"
    );
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                String response = processClientMessage(clientMessage);
                writer.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String processClientMessage(String message) {
        for (var w : vocabulary.keySet()) {
            if (message.contains(w)) {
                return vocabulary.get(w);
            }
        }
        return "Я даже не знаю, что ответить";
    }
}
