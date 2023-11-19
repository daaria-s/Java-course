package edu.project3;

import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static edu.project3.LogsParser.parseFilesWithLogs;
import static edu.project3.Main.createResourcesReport;
import static edu.project3.PrettyOutput.outputReportAdoc;
import static edu.project3.PrettyOutput.outputReportMarkdown;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class prettyOutputTest {

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
    void markdownOutputTest() {
        var parsedLogs = parseFilesWithLogs("logs/logs2.txt");
        var resources = createResourcesReport(parsedLogs);

        outputReportMarkdown(resources, "actualOutput.md");
        assertTrue(isEqual(Path.of("expectedOutput.md"), Path.of("actualOutput.md")));

    }



    @Test
    void adocOutputTest() {
        var parsedLogs = parseFilesWithLogs("logs/logs2.txt");
        var resources = createResourcesReport(parsedLogs);

        outputReportAdoc(resources, "actualOutput.adoc");
        assertTrue(isEqual(Path.of("expectedOutput.adoc"), Path.of("actualOutput.adoc")));
    }
}
