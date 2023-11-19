package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task2.CloneFile.cloneFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    boolean isEqual(Path firstFile, Path secondFile)
    {
        try {
            if (Files.size(firstFile) != Files.size(secondFile)) {
                return false;
            }
            try (BufferedReader bf1 = Files.newBufferedReader(firstFile);
                 BufferedReader bf2 = Files.newBufferedReader(secondFile))
            {
                int ch;
                while ((ch = bf1.read()) != -1)
                {
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

    @Test
    void cloneFileTest() {
        String fileName = "src/main/java/edu/hw6/Task2/someFile.txt";
        String fileNameCopy1 = "src/main/java/edu/hw6/Task2/someFile — копия.txt";
        String fileNameCopy2 = "src/main/java/edu/hw6/Task2/someFile — копия (2).txt";
        String fileNameCopy3 = "src/main/java/edu/hw6/Task2/someFile — копия (3).txt";
        Path path = Path.of(fileName);


        cloneFile(path);
        File fileCopy1 = new File(fileNameCopy1);
        assertTrue(fileCopy1.exists());
        assertTrue(isEqual(path, Path.of(fileNameCopy1)));

        cloneFile(path);
        File fileCopy2 = new File(fileNameCopy2);
        assertTrue(fileCopy2.exists());
        assertTrue(isEqual(path, Path.of(fileNameCopy2)));

        cloneFile(path);
        File fileCopy3 = new File(fileNameCopy3);
        assertTrue(fileCopy3.exists());
        assertTrue(isEqual(path, Path.of(fileNameCopy3)));


    }
}
