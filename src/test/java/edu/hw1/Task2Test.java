package edu.hw1;

import edu.hw1.Task2;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void validTest() {
        assertEquals(4, edu.hw1.Task2.countDigits(1234));
        assertEquals(2, edu.hw1.Task2.countDigits(67));
        assertEquals(1, edu.hw1.Task2.countDigits(9));
        assertEquals(8, edu.hw1.Task2.countDigits(67895046));
    }

    @Test
    void zeroTest() {
        assertEquals(1, edu.hw1.Task2.countDigits(0));
    }

    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            Random rn = new Random();
            int number = rn.nextInt(1000000);
            assertEquals(Integer.toString(number).length(), Task2.countDigits(number));
        }
    }

}
