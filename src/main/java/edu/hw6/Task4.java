package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class Task4 {

    static void outputStreamComposition(Path filePath) {

        try (
            OutputStream fileOutputStream = Files.newOutputStream(filePath);
            var checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());

            var bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            var outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);

            var printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        outputStreamComposition(Path.of("hello.txt"));
    }
}
