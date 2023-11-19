package edu.project3;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static edu.project3.Main.applyFromToDates;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    LogRecord getLogWithDate(OffsetDateTime dt) {
        return new LogRecord("", "",
            dt, "", 0, 0, "", ""
        );
    }

    @Test
    void applyFromToDatesTest() {
        LogRecord firstLog = getLogWithDate(OffsetDateTime.of(2020, 1, 1,
            0, 0, 0, 0, ZoneOffset.UTC
        ));

        LogRecord secondtLog = getLogWithDate(OffsetDateTime.of(2021, 1, 1,
            0, 0, 0, 0, ZoneOffset.UTC
        ));
        LogRecord thirdLog = getLogWithDate(OffsetDateTime.of(2022, 1, 1,
            0, 0, 0, 0, ZoneOffset.UTC
        ));
        LogRecord fourthLog = getLogWithDate(OffsetDateTime.of(2023, 1, 1,
            0, 0, 0, 0, ZoneOffset.UTC
        ));

        ArrayList<LogRecord> logs = new ArrayList<>(List.of(firstLog, secondtLog, thirdLog, fourthLog));
        assertEquals(logs, applyFromToDates(logs, Optional.empty(), Optional.empty()));

        logs.remove(3);
        assertEquals(logs, applyFromToDates(logs, Optional.empty(), Optional.of(LocalDate.of(2022, 5, 5))));

        logs.remove(0);
        assertEquals(
            logs,
            applyFromToDates(logs, Optional.of(LocalDate.of(2020, 5, 5)), Optional.of(LocalDate.of(2022, 5, 5)))
        );

    }
}
