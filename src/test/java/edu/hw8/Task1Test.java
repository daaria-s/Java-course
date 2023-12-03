package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    @Test
    void ClientServerTest() throws IOException, InterruptedException {

        Thread serverThread = new Thread(() -> new Server(2).createServer());

        File inputFile1 = new File("input1.txt");
        InputStream inputStream1 = new FileInputStream(inputFile1);

        File expectedOutputFile1 = new File("actualOutput1.txt");
        PrintStream outputStream1 = new PrintStream(expectedOutputFile1);

        Thread clientThread1 = new Thread(() -> new Client().createClient(inputStream1, outputStream1));

        File inputFile2 = new File("input2.txt");
        InputStream inputStream2 = new FileInputStream(inputFile2);

        File expectedOutputFile2 = new File("actualOutput2.txt");
        PrintStream outputStream2 = new PrintStream(expectedOutputFile2);

        Thread clientThread2 = new Thread(() -> new Client().createClient(inputStream2, outputStream2));

        serverThread.start();
        System.out.println("Server started");

        TimeUnit.SECONDS.sleep(2);

        clientThread1.start();
        System.out.println("Client1 started");

        clientThread2.start();
        System.out.println("Client2 started");

        clientThread1.join();
        clientThread2.join();
        serverThread.interrupt();

        outputStream1.close();
        inputStream1.close();

        outputStream2.close();
        inputStream2.close();

        assertTrue(isEqual(Path.of("expectedOutput1.txt"), Path.of("actualOutput1.txt")));
        assertTrue(isEqual(Path.of("expectedOutput2.txt"), Path.of("actualOutput2.txt")));

    }


    boolean isEqual(Path firstFile, Path secondFile) {
        try {
            if (Files.size(firstFile) != Files.size(secondFile)) {
                return false;
            }
            try (BufferedReader bf1 = Files.newBufferedReader(firstFile);
                 BufferedReader bf2 = Files.newBufferedReader(secondFile)) {
                int ch;
                while ((ch = bf1.read()) != -1) {
                    if (ch != bf2.read()) {
                        return false;
                    }
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
