package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.ThreadSafeCount.threadSafeCount;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    void threadSafeCountTest() {
        assertEquals(1000, threadSafeCount(1000));
        assertEquals(100000, threadSafeCount(100000));
        assertEquals(10000000, threadSafeCount(10000000));
        assertEquals(1, threadSafeCount(1));
        assertEquals(0, threadSafeCount(0));
    }
}
