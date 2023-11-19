package edu.project3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogsStatistics {

    static final int AMOUNT_OF_DATA_FOR_STATISTIC = 10;

    private LogsStatistics() {}

    static long amountOfLogs(Stream<LogRecord> logs) {
        return logs.count();
    }

    static long averageSizeOfAnswer(Stream<LogRecord> logs) {
        return (long) logs.map(LogRecord::bodyBytesSent).mapToDouble(a -> a).average().orElse(0.0);
    }

    public static List<Map.Entry<String, String>> mostFrequentlyRequestedResources(Stream<LogRecord> logs) {
        return logs
            .map((LogRecord log) -> {
                Matcher m = Pattern.compile("^GET ([^\s]*)").matcher(log.request());
                if (m.find()) {
                    return m.group(1);
                }
                return null;
            })
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(String::valueOf)).entrySet().stream().map(
                (Map.Entry<String, List<String>> entry) -> Map.entry(entry.getKey(), entry.getValue().size())
            ).sorted(Comparator.comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed())
            .map((Map.Entry<String, Integer> entry) -> Map.entry(entry.getKey(), String.valueOf(entry.getValue())))
            .limit(AMOUNT_OF_DATA_FOR_STATISTIC).toList();
    }

    static List<Map.Entry<String, String>> mostCommonResponseCodes(Stream<LogRecord> logs) {
        return logs
            .map(LogRecord::status)
            .collect(Collectors.groupingBy(Integer::valueOf)).entrySet().stream().map(
                ((Map.Entry<Integer, List<Integer>> entry) -> Map.entry(entry.getKey(), entry.getValue().size()))
            ).sorted(Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue()).reversed())
            .map(e -> Map.entry(String.valueOf(e.getKey()), String.valueOf(e.getValue())))
            .limit(AMOUNT_OF_DATA_FOR_STATISTIC).toList();

    }
}
