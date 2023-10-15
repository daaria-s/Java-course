package hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {

    @Test
    void validTest() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
        assertTrue(Task5.isPalindromeDescendant(11));
    }

    @Test
    void invalidTest() {
        assertFalse(Task5.isPalindromeDescendant(1));
        assertFalse(Task5.isPalindromeDescendant(12367));
        assertFalse(Task5.isPalindromeDescendant(343311));
    }
}
