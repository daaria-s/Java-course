package edu.hw3;

import edu.hw3.task7.MyComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    void myComparatorNullKeyTest() {

        TreeMap<String, String> tree = new TreeMap<>(new MyComparator<>());

        tree.put(null, "test");
        assertTrue(tree.containsKey(null));

        tree.remove(null);
        assertFalse(tree.containsKey(null));

    }

    @Test
    void myComparatorNullValueTest() {

        TreeMap<String, String> tree = new TreeMap<>(new MyComparator<>());

        tree.put("test", null);
        assertTrue(tree.containsValue(null));

        tree.remove("test", null);
        assertFalse(tree.containsValue(null));

    }

    @Test
    void myComparatorAllNullTest() {

        TreeMap<String, String> tree = new TreeMap<>(new MyComparator<>());

        tree.put(null, null);
        assertTrue(tree.containsValue(null));
        assertTrue(tree.containsKey(null));

        tree.remove(null, null);
        assertFalse(tree.containsValue(null));
        assertFalse(tree.containsKey(null));
    }
}
