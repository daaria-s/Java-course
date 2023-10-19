package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void validTest() {
        assertEquals(5, edu.hw1.Task6.countK(6621));
        assertEquals(4, edu.hw1.Task6.countK(6554));
        assertEquals(3, edu.hw1.Task6.countK(1234));
        assertEquals(3, edu.hw1.Task6.countK(5432));

    }

    @Test
    void zeroStepsTest() {
        assertEquals(0, Task6.countK(6174));
    }
}
