package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    void backwardIteratorTest() {

        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void backwardIteratorEmptyTest() {

        Iterator<Integer> iterator = new BackwardIterator<>(List.of());

        assertFalse(iterator.hasNext());

    }
}
