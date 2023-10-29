package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static edu.hw3.Task3.freqDict;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    class SomeClass {
        int someValue;

        SomeClass(int value) {
            this.someValue = value;
        }
    }

    @Test
    void freqDictWithStringTest() {
        assertEquals(Map.of("bb", 2, "a", 2), freqDict(new ArrayList<>(List.of("a", "bb", "a", "bb"))));
        assertEquals(
            Map.of("this", 1, "that", 1, "and", 2),
            freqDict(new ArrayList<>(List.of("this", "and", "that", "and")))
        );
        assertEquals(Map.of("код", 3, "bug", 1), freqDict(new ArrayList<>(List.of("код", "код", "код", "bug"))));
    }

    @Test
    void freqDictWithIntTest() {
        assertEquals(Map.of(1, 3, 2, 1, 3, 1, 4, 1), freqDict(new ArrayList<>(List.of(1, 1, 1, 2, 3, 4))));
        assertEquals(Map.of(0, 1), freqDict(new ArrayList<>(List.of(0))));
        assertEquals(
            Map.of(1000000, 1, 2000000, 2, 3000000, 3),
            freqDict(new ArrayList<>(List.of(1000000, 2000000, 2000000, 3000000, 3000000, 3000000)))
        );
    }

    @Test
    void freqDictWithSomeClassTest() {
        SomeClass someClass1 = new SomeClass(1);
        SomeClass someClass2 = new SomeClass(2);
        SomeClass someClass3 = new SomeClass(3);
        assertEquals(
            Map.of(someClass1, 1, someClass2, 2, someClass3, 1),
            freqDict(new ArrayList<>(List.of(someClass1, someClass2, someClass3, someClass2)))
        );

    }

    @Test
    void freqDictWithEmptyTest() {
        assertEquals(Map.of(), freqDict(new ArrayList<>()));
    }
}
