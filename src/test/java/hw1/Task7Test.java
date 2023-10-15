package hw1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {


    @Test
    void rotateRightTest() {
        assertEquals(Task7.rotateRight(8, 1), 4);
        assertEquals(Task7.rotateRight(63, 63), 63);

    }

    @Test
    void rotateLeftTest() {
        assertEquals(Task7.rotateLeft(16, 1), 1);
        assertEquals(Task7.rotateLeft(17, 2), 6);
        assertEquals(Task7.rotateLeft(31, 6), 31);
    }

    @Test
    void randomTest() {
        Random rn = new Random();
        int number = rn.nextInt(10000);
        assertEquals(Task7.rotateRight(number * 8, 3), number);
    }
}
