package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static edu.hw5.Task.averagePasttime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void averagePasttimeTest() {
        Duration expectedDuration = Duration.ofMinutes(3 * 60 + 40);
        String[] durations =
            new String[] {"2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20",
                "2022-03-12, 17:20 - 2022-03-12, 20:50",
                "2022-04-01, 23:45 - 2022-04-02, 03:35"};
        assertEquals(expectedDuration, averagePasttime(durations));
    }

    @Test
    void averagePasttimeZeroTimeTest() {
        Duration expectedDuration = Duration.ofMinutes(0);
        String[] durations =
            new String[] {"2000-03-01, 01:01 - 2000-03-01, 01:01",
                "2001-07-08, 07:10 - 2001-07-08, 07:10",
                "2001-04-01, 03:35 - 2001-04-01, 03:35"};
        assertEquals(expectedDuration, averagePasttime(durations));
    }

    @Test
    void averagePasttimeLongTimeTest() {
        Duration expectedDuration = Duration.ofMinutes(48 * 60);
        String[] durations =
            new String[] {"2020-12-12, 01:00 - 2020-12-13, 01:00",
                "2020-12-13, 21:30 - 2020-12-16, 21:30"};
        assertEquals(expectedDuration, averagePasttime(durations));

    }
}
