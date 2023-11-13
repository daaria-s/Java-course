package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import static edu.hw5.Task.findAllFriday13Th;
import static edu.hw5.Task.findNextFriday13Th;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    void findAllFriday13ThTest1() {
        ArrayList<LocalDate> expected = new ArrayList<>(Arrays.asList(
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13)
        ));

        Assertions.assertEquals(expected, findAllFriday13Th(1925));
    }

    @Test
    void findAllFriday13ThTest2() {
        ArrayList<LocalDate> expected = new ArrayList<>(Arrays.asList(
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        ));

        Assertions.assertEquals(expected, findAllFriday13Th(2024));
    }


    @Test
    void findNextFriday13ThTest1() {
        LocalDate expected = LocalDate.of(2024, 9, 13);
        assertEquals(expected, findNextFriday13Th(LocalDate.of(2024, 1, 1)));

    }


    @Test
    void findNextFriday13ThTest2() {
        LocalDate expected = LocalDate.of(1925, 11, 13);
        assertEquals(expected, findNextFriday13Th(LocalDate.of(1925, 11, 12)));

    }

    @Test
    void findNextFriday13ThTest3() {
        LocalDate expected = LocalDate.of(2024, 9, 13);
        assertEquals(expected, findNextFriday13Th(LocalDate.of(2023, 12, 31)));

    }
}

