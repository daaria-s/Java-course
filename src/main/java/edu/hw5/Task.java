package edu.hw5;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {

    private Task() {
    }

    static final int MONTHS_IN_YEAR = 12;

    static final int FRIDAY_13TH_DAY = 13;

    // task1
    public static Duration averagePasttime(String[] times) {
        int n = times.length;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, kk:mm");
        Duration result = Duration.ZERO;
        for (String time : times) {

            String[] splittedTime = time.split(" - ");
            result = result.plus(Duration.between(
                LocalDateTime.parse(splittedTime[0], dateTimeFormatter),
                LocalDateTime.parse(splittedTime[1], dateTimeFormatter)
            ));
        }

        result = result.dividedBy(n);

        return result;
    }

    // task2

    public static ArrayList<LocalDate> findAllFriday13Th(int year) {
        ArrayList<LocalDate> answer = new ArrayList<>();

        for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
            LocalDate currentDate = LocalDate.of(year, month, FRIDAY_13TH_DAY);
            if (currentDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                answer.add(currentDate);
            }
        }
        return answer;
    }

    public static LocalDate findNextFriday13Th(LocalDate localDate) {
        TemporalAdjuster nextFriday13Th = TemporalAdjusters.ofDateAdjuster(date -> {
            for (var data : findAllFriday13Th((date.getYear()))) {
                if (date.isBefore(data)) {
                    return data;
                }
            }
            return findAllFriday13Th((date.getYear() + 1)).get(0);
        });
        return localDate.with(nextFriday13Th);
    }

    // task3

    public static Optional<LocalDate> parseDate(String date) {
        DataParser[] allFormatters = new DataParser[] {
            new DataFormatterParser("yyyy-MM-dd"),
            new DataFormatterParser("yyyy-MM-d"),
            new DataFormatterParser("d/M/yyyy"),
            new DataFormatterParser("d/M/yy"),
            new YesterdayParser(),
            new TomorrowParser(),
            new TodayParser(),
            new SomeDaysAgoParser()
        };

        for (var formatter : allFormatters) {
            Optional<LocalDate> result = formatter.parse(date);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();

    }

    // task4
    public static boolean passwordContainsSymbols(String password) {
        Pattern pattern = Pattern.compile("[~!@#$%^&*|]");
        return pattern.matcher(password).find();
    }

    // task5
    public static boolean isValidCarNumber(String number) {
        Pattern pattern = Pattern.compile("^[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}\\d{3}$");
        return pattern.matcher(number).find();
    }

    //task6
    public static boolean isSubsequence(String s, String t) {
        StringBuilder patternBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                patternBuilder.append(".*");
            }
            patternBuilder.append(s.charAt(i));
        }
        System.out.println(patternBuilder);
        Pattern pattern = Pattern.compile(patternBuilder.toString());
        return pattern.matcher(t).find();
    }

    //task7
    public static boolean lenghtAtLeast3And0IsThird(String string) {
        Pattern pattern = Pattern.compile("^[01]{2}0");
        return pattern.matcher(string).find();
    }

    public static boolean startsAndEndsWithSameSymbol(String string) {
        Pattern pattern = Pattern.compile("^(^0[01]*0$)|(^1[01]*1$)$");
        return pattern.matcher(string).find();
    }

    public static boolean lengthFrom1To3(String string) {
        Pattern pattern = Pattern.compile("^[01]{1,3}$");
        return pattern.matcher(string).find();
    }

    // task8
    public static boolean oddLenght(String string) {
        Pattern pattern = Pattern.compile("^([01][01])*[01]$");
        return pattern.matcher(string).find();
    }

    public static boolean start0OddLenghtOrStart1EvenLenght(String string) {
        Pattern pattern = Pattern.compile("^(^0([01][01])*$)|(^1[01]([01][01])*$)$");
        return pattern.matcher(string).find();
    }

    public static boolean numberOf0DividedBy3(String string) {
        Pattern pattern = Pattern.compile("^(1*01*01*01*)*1?$");
        return pattern.matcher(string).find();
    }

    public static boolean everyOddSymbolIs1(String string) {

        Pattern pattern = Pattern.compile("^([01]1)*[01]?$");
        return pattern.matcher(string).find();
    }

    // task3
    interface DataParser {
        Optional<LocalDate> parse(String date);
    }

    public static class YesterdayParser implements DataParser {
        @Override
        public Optional<LocalDate> parse(String date) {
            if (date.equalsIgnoreCase("yesterday") || date.equalsIgnoreCase("1 day ago")) {
                return Optional.of(LocalDate.now().minusDays(1));
            }
            return Optional.empty();
        }
    }

    public static class SomeDaysAgoParser implements DataParser {
        @Override
        public Optional<LocalDate> parse(String date) {
            Pattern pattern = Pattern.compile("^([1-9]\\d*) days ago$");
            Matcher matcher = pattern.matcher(date);
            if (matcher.find()) {
                return Optional.of(LocalDate.now().minusDays(Integer.parseInt(matcher.group(1))));
            }
            return Optional.empty();
        }
    }

    public static class TomorrowParser implements DataParser {
        @Override
        public Optional<LocalDate> parse(String date) {
            if (date.equalsIgnoreCase("tomorrow")) {
                return Optional.of(LocalDate.now().plusDays(1));
            }
            return Optional.empty();
        }
    }

    public static class TodayParser implements DataParser {
        @Override
        public Optional<LocalDate> parse(String date) {
            if (date.equalsIgnoreCase("today")) {
                return Optional.of(LocalDate.now());
            }
            return Optional.empty();
        }
    }

    public static class DataFormatterParser implements DataParser {
        DateTimeFormatter myFormatter;

        DataFormatterParser(String pattern) {
            myFormatter = DateTimeFormatter.ofPattern(pattern);
        }

        @Override
        public Optional<LocalDate> parse(String date) {
            try {
                LocalDate parsedDate = LocalDate.parse(date, myFormatter);
                return Optional.of(parsedDate);
            } catch (Exception ignored) {
                return Optional.empty();
            }
        }
    }

}
