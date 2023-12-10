package edu.hw9;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import static edu.hw9.Task3.DfsConcurrent.dfs;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {



    void atomicArraysEquals(AtomicBoolean[] expected, AtomicBoolean[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].get(), actual[i].get());
        }
    }

    @Test
    void dfsConcurrentTest1() {
        Map<Integer, int[]> graph = Map.of(0, new int[] {1, 2},
            1, new int[] {2, 3},
            2, new int[] {},
            3, new int[] {},
            4, new int[] {0}
        );

        AtomicBoolean[] actual = dfs(0, graph, 4);

        AtomicBoolean[] expected = new AtomicBoolean[] {new AtomicBoolean(true),
            new AtomicBoolean(true),
            new AtomicBoolean(true),
            new AtomicBoolean(true),
            new AtomicBoolean(false)};

        atomicArraysEquals(expected, actual);
    }
    @Test
    void dfsConcurrentTest2() {
        Map<Integer, int[]> graph = Map.of(0, new int[] {},
            1, new int[] {},
            2, new int[] {},
            3, new int[] {},
            4, new int[] {}
        );

        AtomicBoolean[] actual = dfs(3, graph, 4);

        AtomicBoolean[] expected = new AtomicBoolean[] {new AtomicBoolean(false),
            new AtomicBoolean(false),
            new AtomicBoolean(false),
            new AtomicBoolean(true),
            new AtomicBoolean(false)};

        atomicArraysEquals(expected, actual);
    }


}
