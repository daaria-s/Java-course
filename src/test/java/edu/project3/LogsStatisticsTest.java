package edu.project3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static edu.project3.LogsStatistics.amountOfLogs;
import static edu.project3.LogsStatistics.averageSizeOfAnswer;
import static edu.project3.LogsStatistics.mostCommonResponseCodes;
import static edu.project3.LogsStatistics.mostFrequentlyRequestedResources;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogsStatisticsTest {

    LogRecord log = new LogRecord("", "", null, "", 1, 1, "", "");

    LogRecord getLogWithBytesSent(int bytes) {
        return new LogRecord("", "", null, "", 1, bytes, "", "");

    }
    LogRecord getLogWithStatus(int status) {
        return new LogRecord("", "", null, "", status, 1, "", "");

    }

    LogRecord getLogWithRequest(String request) {
        return new LogRecord("", "", null, request, 1, 1, "", "");

    }

    @Test
    void amountOfLogsTest() {
        ArrayList<LogRecord> logs = new ArrayList<>();
        assertEquals(0, amountOfLogs(logs.stream()));

        logs.add(log);
        logs.add(log);
        logs.add(log);
        assertEquals(3, amountOfLogs(logs.stream()));
    }

    @Test
    void averageSizeOfAnswerTest() {
        List<LogRecord> logs = List.of(getLogWithBytesSent(0), getLogWithBytesSent(100),
            getLogWithBytesSent(50), getLogWithBytesSent(25), getLogWithBytesSent(75)
        );

        assertEquals(50, averageSizeOfAnswer(logs.stream()));

    }

    @Test
    void mostFrequentlyRequestedResourcesTest() {
        List<LogRecord> logs = List.of(getLogWithRequest("GET resource1 "),
            getLogWithRequest("GET resource2 "),
            getLogWithRequest("GET resource2 "),
            getLogWithRequest("GET resource3 "),
            getLogWithRequest("GET resource3 "),
            getLogWithRequest("GET resource3 ")
        );

        List<Map.Entry<String, String>> expected = List.of(Map.entry("resource3", "3"),
            Map.entry("resource2", "2"),
            Map.entry("resource1", "1"));

        assertEquals(expected, mostFrequentlyRequestedResources(logs.stream()));
    }

    @Test
    void mostCommonResponseCodesTest() {
        List<LogRecord> logs = List.of(getLogWithStatus(404),
            getLogWithStatus(404),
            getLogWithStatus(304),
            getLogWithStatus(304),
            getLogWithStatus(404),
            getLogWithStatus(200)
        );

        List<Map.Entry<String, String>> expected = List.of(Map.entry("404", "3"),
            Map.entry("304", "2"),
            Map.entry("200", "1"));

        assertEquals(expected, mostCommonResponseCodes(logs.stream()));

    }
}

