package edu.project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsParser {

    private static Logger logger = LogManager.getLogger(LogsParser.class);

    private LogsParser() {
    }

    @SuppressWarnings("MagicNumber")
    static LogRecord parseLog(String logString) {
        Pattern logPattern =
            Pattern.compile("^([^\s]+) - ([^\s]+) \\[(.+)\\] \"([^\"]+)\" "
                + "(\\d+) (\\d+) \"([^\"]+)\" \"([^\"]+)\"$");

        Matcher logMatcher = logPattern.matcher(logString);
        if (logMatcher.find()) {
            String remoteAddr = logMatcher.group(1);
            String remoteUser = logMatcher.group(2);
            OffsetDateTime timeLocal =
                OffsetDateTime.parse(logMatcher.group(3), DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z"));
            String request = logMatcher.group(4);
            int status = Integer.parseInt(logMatcher.group(5));
            int bodyBytesSent = Integer.parseInt(logMatcher.group(6));
            String httpReferer = logMatcher.group(7);
            String httpUserAgent = logMatcher.group(8);

            return new LogRecord(
                remoteAddr,
                remoteUser,
                timeLocal,
                request,
                status,
                bodyBytesSent,
                httpReferer,
                httpUserAgent
            );
        }
        return null;

    }

    static Stream<LogRecord> parseOneLocalFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return parseFromBufferedReader(reader);
        } catch (IOException ex) {
            logger.error(ex.getMessage());

        }
        return null;
    }

    static Stream<LogRecord> parseFromBufferedReader(BufferedReader reader) {

        try {
            ArrayList<String> stringsOfLogs = new ArrayList<>();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                stringsOfLogs.add(inputLine);
            }
            reader.close();
            return stringsOfLogs.stream().map(LogsParser::parseLog);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    static Stream<LogRecord> parseOneURL(String url) {
        try {
            URL urlPath = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlPath.openStream()));
            return parseFromBufferedReader(reader);

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    static public List<LogRecord> parseDirectoryWithLogs(File[] directoryListing) {
        Stream<LogRecord> result = Stream.empty();

        for (File file : directoryListing) {
            Stream<LogRecord> parsedFile = parseOneLocalFile(file);
            if (parsedFile != null) {
                result = Stream.concat(result, parsedFile);
            }
        }
        return result.toList();
    }

    static public List<LogRecord> parseFilesWithLogs(String path) {

        if (path.startsWith("http")) {
            return parseOneURL(path).toList();
        }

        File directoryOrPath = new File(path);
        if (directoryOrPath.exists()) {
            if (directoryOrPath.isFile()) {
                return parseOneLocalFile(directoryOrPath).toList();
            } else if (directoryOrPath.isDirectory()) {
                File[] directoryListing = directoryOrPath.listFiles();
                if (directoryListing != null) {
                    return parseDirectoryWithLogs(directoryListing);
                }
            }
        }
        return null;
    }
}
