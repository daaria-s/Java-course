package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task2.ParallelFactorial.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void factorialTest() {
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(24, factorial(4));
        assertEquals(720, factorial(6));
        assertEquals(5040, factorial(7));
        assertEquals(362880, factorial(9));
    }
}
