package edu.hw6.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CloneFile {

    static void cloneFile(Path originalPath) throws IOException {

        String pathWithoutFileName = originalPath.toFile().getParent();

        String originalFileName = originalPath.getFileName().toString();

        String copyFileName;

        Pattern pattern1Copy = Pattern.compile("^(.*) — копия\\.txt$");
        Matcher oneCopyMatcher = pattern1Copy.matcher(originalFileName);

        Pattern patternManyCopies = Pattern.compile("^(.*) — копия \\((\\d*)\\)\\.txt$");
        Matcher manyCopiesMatcher = patternManyCopies.matcher(originalFileName);

        Pattern patternNoCopy = Pattern.compile("^(.*)\\.txt$");

        Matcher noCopyMatcher = patternNoCopy.matcher(originalFileName);
        if (oneCopyMatcher.find()) {
            copyFileName = oneCopyMatcher.group(1) + " — копия (2).txt";
        }
        else if (manyCopiesMatcher.find()) {
            copyFileName = manyCopiesMatcher.group(1) + " — копия (" + (Integer.parseInt(manyCopiesMatcher.group(2)) + 1) + ").txt";
        }
        else {
            copyFileName = noCopyMatcher.group(1) + " — копия.txt";
        }

        Path copiedPath = Paths.get(pathWithoutFileName + "/" + copyFileName);
        if (new File(copiedPath.toString()).exists()) {
            cloneFile(copiedPath);
        }

        Files.copy(originalPath, copiedPath, StandardCopyOption.REPLACE_EXISTING);

    }

    public static void main(String[] args) throws IOException {

        cloneFile(Paths.get("src/main/java/edu/hw6/myMap.txt"));
    }
}
