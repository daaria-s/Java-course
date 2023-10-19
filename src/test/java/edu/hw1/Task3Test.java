package edu.hw1;

import edu.hw1.Task3;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    void trueTest() {
        assertTrue(edu.hw1.Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
        assertTrue(edu.hw1.Task3.isNestable(new int[]{3, 1}, new int[]{4, 0}));
        assertTrue(edu.hw1.Task3.isNestable(new int[]{17, 27, 41, 39, 42, 18}, new int[]{16, 43, 20, 25, 30}));
    }

    @Test
    void falseTest() {
        assertFalse(edu.hw1.Task3.isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));
        assertFalse(edu.hw1.Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));
        assertFalse(edu.hw1.Task3.isNestable(new int[]{16, 17, 18, 19, 20}, new int[]{16, 17, 18, 19, 20}));
    }

    @Test
    void emptyArrayTest() {
        assertFalse(edu.hw1.Task3.isNestable(new int[]{1, 2, 3, 4}, new int[0]));
        assertFalse(edu.hw1.Task3.isNestable(new int[0], new int[]{79, 80, 86, 90}));
        assertFalse(edu.hw1.Task3.isNestable(new int[0], new int[0]));
    }

    @Test
    void longArrayTest() {
        int[] firstArray = IntStream.rangeClosed(100, 100000).toArray();
        int[] secondArray = IntStream.rangeClosed(10, 1000000).toArray();

        assertTrue(edu.hw1.Task3.isNestable(firstArray, secondArray));
        assertFalse(Task3.isNestable(firstArray, firstArray));
    }


}
