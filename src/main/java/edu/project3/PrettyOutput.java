package edu.project3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrettyOutput {

    private static Logger logger = LogManager.getLogger(PrettyOutput.class);
    static final String CELL_SEPARATOR = " | ";
    static final String ENTITY_SEPARATOR = "|====";

    private PrettyOutput() {}

    static public void outputReportMarkdown(LogReport report, String file) {

        try (
            FileWriter fileWriter = new FileWriter(file, true);

            PrintWriter printWriter = new PrintWriter(fileWriter, true);
        ) {
            printWriter.println("### " + report.title);
            printWriter.println("");
            printWriter.println("| " + report.keyTitle + CELL_SEPARATOR + report.valueTitle + " |");
            printWriter.println("| :----: | :----: |");

            for (var line : report.data) {
                printWriter.println("| " + line.getKey() + CELL_SEPARATOR + line.getValue() + " |");
            }
            printWriter.println("");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    static public void outputReportAdoc(LogReport report, String file) {

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter printWriter = new PrintWriter(fileWriter, true)) {

            printWriter.println("== " + report.title);
            printWriter.println("");
            printWriter.println("[cols=2]");
            printWriter.println(ENTITY_SEPARATOR);
            printWriter.println("|" + report.keyTitle + " |" + report.valueTitle);

            for (var line : report.data) {
                printWriter.println("| " + line.getKey());
                printWriter.println("| " + line.getValue());
            }
            printWriter.println(ENTITY_SEPARATOR);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}
