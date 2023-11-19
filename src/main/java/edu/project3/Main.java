package edu.project3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import static edu.project3.LogsParser.parseFilesWithLogs;
import static edu.project3.LogsStatistics.amountOfLogs;
import static edu.project3.LogsStatistics.averageSizeOfAnswer;
import static edu.project3.LogsStatistics.mostCommonResponseCodes;
import static edu.project3.LogsStatistics.mostFrequentlyRequestedResources;
import static edu.project3.PrettyOutput.outputReportAdoc;
import static edu.project3.PrettyOutput.outputReportMarkdown;

@SuppressWarnings("MultipleStringLiterals")
public class Main {

    private Main() {
    }

    static LogReport createGeneralInfoReport(
        String path,
        Optional<LocalDate> fromDate,
        Optional<LocalDate> toDate,
        List<LogRecord> parsedLogs
    ) {

        String fromDateString = "-";
        if (fromDate.isPresent()) {
            fromDateString = fromDate.get().toString();
        }
        String toDateString = "-";
        if (toDate.isPresent()) {
            toDateString = toDate.get().toString();
        }
        LogReport generalInfo = new LogReport("Общая информация", "Метрика", "Значение");
        generalInfo.addInfo("Файл(-ы)", path);
        generalInfo.addInfo("Начальная дата", fromDateString);
        generalInfo.addInfo("Конечная дата", toDateString);
        generalInfo.addInfo("Количество запросов", String.valueOf(amountOfLogs(parsedLogs.stream())));
        generalInfo.addInfo("Средний размер ответа", String.valueOf(averageSizeOfAnswer(parsedLogs.stream())));
        return generalInfo;
    }

    static LogReport createResourcesReport(List<LogRecord> parsedLogs) {
        return new LogReport(
            "Запрашиваемые ресурсы",
            "Ресурс",
            "Количество",
            mostFrequentlyRequestedResources(parsedLogs.stream())
        );
    }

    static LogReport createAnswerCodeReports(List<LogRecord> parsedLogs) {
        return new LogReport("Коды ответа", "Код", "Количество",
            mostCommonResponseCodes(parsedLogs.stream())
        );
    }

    static public List<LogRecord> applyFromToDates(
        List<LogRecord> logs,
        Optional<LocalDate> fromDate,
        Optional<LocalDate> toDate
    ) {
        return logs.stream().filter(log -> {
            boolean res = true;
            if (fromDate.isPresent()) {
                res = log.timeLocal().isAfter(OffsetDateTime.of(fromDate.get(), LocalTime.NOON, ZoneOffset.UTC));
            }
            if (toDate.isPresent()) {
                res = res && log.timeLocal().isBefore(OffsetDateTime.of(toDate.get(), LocalTime.NOON, ZoneOffset.UTC));
            }
            return res;
        }).toList();
    }

    static final String DEFAULT_FORMAT = "markdown";
    static final String FILE_FOR_MARKDOWN = "output.md";
    static final String FILE_FOR_ADOC = "output.adoc";

    public static void main(String[] args) {

        String path = "";
        String outputformat = DEFAULT_FORMAT;
        Optional<LocalDate> fromDate = Optional.empty();
        Optional<LocalDate> toDate = Optional.empty();

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "--path":
                    path = args[i + 1];
                    break;
                case "--from":
                    fromDate = Optional.of(LocalDate.parse(args[i + 1]));
                    break;

                case "--to":
                    toDate = Optional.of(LocalDate.parse(args[i + 1]));
                    break;

                case "--format":
                    outputformat = args[i + 1];
                    break;
                default:
            }
        }

        var parsedLogs = parseFilesWithLogs(path);

        assert (parsedLogs != null);
        parsedLogs = applyFromToDates(parsedLogs, fromDate, toDate);

        LogReport generalInfo = createGeneralInfoReport(path, fromDate, toDate, parsedLogs);
        LogReport resources = createResourcesReport(parsedLogs);
        LogReport answerCodes = createAnswerCodeReports(parsedLogs);

        if (outputformat.equals("markdown")) {
            outputReportMarkdown(generalInfo, FILE_FOR_MARKDOWN);
            outputReportMarkdown(resources, FILE_FOR_MARKDOWN);
            outputReportMarkdown(answerCodes, FILE_FOR_MARKDOWN);
        } else {
            outputReportAdoc(generalInfo, FILE_FOR_ADOC);
            outputReportAdoc(resources, FILE_FOR_ADOC);
            outputReportAdoc(answerCodes, FILE_FOR_ADOC);
        }
    }
}
