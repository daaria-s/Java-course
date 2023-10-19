package edu.hw1;

import edu.hw1.Task1;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void validTest() {
        assertEquals(edu.hw1.Task1.minutesToSeconds("01:00"), 60);
        assertEquals(edu.hw1.Task1.minutesToSeconds("13:56"), 836);
        assertEquals(edu.hw1.Task1.minutesToSeconds("0:43"), 43);
    }

    @Test
    void invalidTest() {
        assertEquals(edu.hw1.Task1.minutesToSeconds("00:60"), -1);
        assertEquals(edu.hw1.Task1.minutesToSeconds("79:79"), -1);
        assertEquals(edu.hw1.Task1.minutesToSeconds("-5:40"), -1);
        assertEquals(edu.hw1.Task1.minutesToSeconds("00:-12"), -1);
        assertEquals(edu.hw1.Task1.minutesToSeconds("00::12"), -1);
    }

    @Test
    void zeroMinutesTest() {
        assertEquals(edu.hw1.Task1.minutesToSeconds("00:00"), 0);
        assertEquals(edu.hw1.Task1.minutesToSeconds("000:00"), 0);
        assertEquals(edu.hw1.Task1.minutesToSeconds("0:00"), 0);
    }

    @Test
    void longMinutesTest() {
        assertEquals(edu.hw1.Task1.minutesToSeconds("999:59"), 59999);
        assertEquals(edu.hw1.Task1.minutesToSeconds("79656:01"), 4779361);
    }

    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            Random rn = new Random();
            int minutes = rn.nextInt(1000000);
            int seconds = rn.nextInt(60);
            String stringTime = minutes + ":" + seconds;
            assertEquals(Task1.minutesToSeconds(stringTime), minutes * 60 + seconds,
                    "Given values: " + minutes + " minutes, " + seconds + " seconds");
        }
    }


}
