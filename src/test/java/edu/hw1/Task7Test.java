package edu.hw1;

import edu.hw1.Task7;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {


    @Test
    void rotateRightTest() {
        assertEquals(4, edu.hw1.Task7.rotateRight(8, 1));
        assertEquals(63, edu.hw1.Task7.rotateRight(63, 63));

    }

    @Test
    void rotateLeftTest() {
        assertEquals(1, edu.hw1.Task7.rotateLeft(16, 1));
        assertEquals(6, edu.hw1.Task7.rotateLeft(17, 2));
        assertEquals(31, edu.hw1.Task7.rotateLeft(31, 6));
    }

    @Test
    void randomTest() {
        Random rn = new Random();
        for (int i = 0; i < 100; i++) {
            int number = rn.nextInt(10000);
            assertEquals(number, Task7.rotateRight(number * 8, 3));
        }
    }
}
