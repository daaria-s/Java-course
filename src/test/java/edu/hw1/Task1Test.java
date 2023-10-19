package edu.hw1;

import edu.hw1.Task1;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void validTest() {
        assertEquals(60, edu.hw1.Task1.minutesToSeconds("01:00"));
        assertEquals(836, edu.hw1.Task1.minutesToSeconds("13:56"));
        assertEquals(43, edu.hw1.Task1.minutesToSeconds("0:43"));
    }

    @Test
    void invalidTest() {
        assertEquals(-1, edu.hw1.Task1.minutesToSeconds("00:60"));
        assertEquals(-1, edu.hw1.Task1.minutesToSeconds("79:79"));
        assertEquals(-1, edu.hw1.Task1.minutesToSeconds("-5:40"));
        assertEquals(-1, edu.hw1.Task1.minutesToSeconds("00:-12"));
        assertEquals(-1, edu.hw1.Task1.minutesToSeconds("00::12"));
    }

    @Test
    void zeroMinutesTest() {
        assertEquals(0, edu.hw1.Task1.minutesToSeconds("00:00"));
        assertEquals(0, edu.hw1.Task1.minutesToSeconds("000:00"));
        assertEquals(0, edu.hw1.Task1.minutesToSeconds("0:00"));
    }

    @Test
    void longMinutesTest() {
        assertEquals(59999, edu.hw1.Task1.minutesToSeconds("999:59"));
        assertEquals(4779361, edu.hw1.Task1.minutesToSeconds("79656:01"));
    }

    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            Random rn = new Random();
            int minutes = rn.nextInt(1000000);
            int seconds = rn.nextInt(60);
            String stringTime = minutes + ":" + seconds;
            assertEquals(minutes * 60 + seconds, Task1.minutesToSeconds(stringTime),
                "Given values: " + minutes + " minutes, " + seconds + " seconds"
            );
        }
    }

}
