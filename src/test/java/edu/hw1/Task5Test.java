package edu.hw1;

import edu.hw1.Task5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    void validTest() {
        assertTrue(edu.hw1.Task5.isPalindromeDescendant(11211230));
        assertTrue(edu.hw1.Task5.isPalindromeDescendant(13001120));
        assertTrue(edu.hw1.Task5.isPalindromeDescendant(23336014));
        assertTrue(edu.hw1.Task5.isPalindromeDescendant(11));
    }

    @Test
    void invalidTest() {
        assertFalse(edu.hw1.Task5.isPalindromeDescendant(1));
        assertFalse(edu.hw1.Task5.isPalindromeDescendant(12367));
        assertFalse(edu.hw1.Task5.isPalindromeDescendant(343311));
        assertFalse(Task5.isPalindromeDescendant(34331100));
    }
}
