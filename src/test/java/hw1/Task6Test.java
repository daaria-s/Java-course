package hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {
    @Test
    void validTest() {
        assertEquals(Task6.countK(6621), 5);
        assertEquals(Task6.countK(6554), 4);
        assertEquals(Task6.countK(1234), 3);
        assertEquals(Task6.countK(5432), 3);

    }

    @Test
    void zeroStepsTest() {
        assertEquals(Task6.countK(6174), 0);
    }
}
