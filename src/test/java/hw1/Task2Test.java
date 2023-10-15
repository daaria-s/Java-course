package hw1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void validTest() {
        assertEquals(Task2.countDigits(1234), 4);
        assertEquals(Task2.countDigits(67), 2);
        assertEquals(Task2.countDigits(9), 1);
        assertEquals(Task2.countDigits(67895046), 8);
    }

    @Test
    void zeroTest() {
        assertEquals(Task2.countDigits(0), 1);
    }


    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            Random rn = new Random();
            int number = rn.nextInt(1000000);
            assertEquals(Task2.countDigits(number), Integer.toString(number).length());
        }
    }


}
