package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task.parseDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    void parseDateTest() {
        assertEquals(Optional.of(LocalDate.of(2020, 10, 10)), parseDate("2020-10-10"));
        assertEquals(Optional.of(LocalDate.of(2020, 12, 2)), parseDate("2020-12-2"));
        assertEquals(Optional.of(LocalDate.of(2020, 10, 30)), parseDate("30/10/20"));
        assertEquals(Optional.of(LocalDate.of(1976, 12, 1)), parseDate("1/12/1976"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), parseDate("yesterday"));
        assertEquals(Optional.of(LocalDate.now()), parseDate("today"));
        assertEquals(Optional.of(LocalDate.now().plusDays(1)), parseDate("tomorrow"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), parseDate("1 day ago"));
        assertEquals(Optional.of(LocalDate.now().minusDays(22)), parseDate("22 days ago"));
    }

    @Test
    void parseDateInvalidTest() {
        assertEquals(Optional.empty(), parseDate("hello"));
        assertEquals(Optional.empty(), parseDate("-5/-20/0"));
        assertEquals(Optional.empty(), parseDate("1234567890"));
        assertEquals(Optional.empty(), parseDate(""));
        assertEquals(Optional.empty(), parseDate("tomorrrrow"));
        assertEquals(Optional.empty(), parseDate("long long time ago"));
    }
}
