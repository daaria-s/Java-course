package edu.project3;

import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import static edu.project3.LogsParser.parseFilesWithLogs;
import static edu.project3.LogsParser.parseLog;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LogsParserTest {

    @Test
    void parseLogTest() {

        String log =
            "217.168.17.5 - - [17/May/2015:08:05:34 +0000] \"GET /downloads/product_1 HTTP/1.1\" " +
                "200 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"";
        OffsetDateTime expTime = OffsetDateTime.of(2015, 5, 17, 8, 5, 34, 0, ZoneOffset.UTC);
        LogRecord expected = new LogRecord(
            "217.168.17.5",
            "-",
            expTime,
            "GET /downloads/product_1 HTTP/1.1",
            200,
            490,
            "-",
            "Debian APT-HTTP/1.3 (0.8.10.3)"
        );
        assertEquals(expected, parseLog(log));
    }

    @Test
    void parseLogInvalidTest() {
        String badLog = "this is not log 17/Oct/2025:01:01:01 sdfgh";
        assertNull(parseLog(badLog));
    }

    @Test
    void parseFilesWithLogsTest() {
        String url =
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";
        assertEquals(51462, parseFilesWithLogs(url).size());


        String localFile = "logs.txt";
        assertEquals(454, parseFilesWithLogs(localFile).size());

        String localDirectory = "logs/";

        assertEquals(24, parseFilesWithLogs(localDirectory).size());
    }

}
