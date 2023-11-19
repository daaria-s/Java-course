package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static edu.hw6.Task4.outputStreamComposition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    void outputStreamCompositionTest() {

        Path path = Path.of("test.txt");

        outputStreamComposition(path);

        File file = new File("test.txt");
        assertTrue(file.exists());

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while (reader.ready()) {
                String line = reader.readLine();
                stringBuilder.append(line);
            }
            assertEquals("Programming is learned by writing programs. ― Brian Kernighan", stringBuilder.toString());
        } catch (IOException ignored) {
        }
    }
}
