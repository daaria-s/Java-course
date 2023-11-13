package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task.isValidCarNumber;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    void isValidCarNumberValidTest() {
        assertTrue(isValidCarNumber("A777CC177"));
        assertTrue(isValidCarNumber("E111HH179"));
        assertTrue(isValidCarNumber("K222PK169"));
        assertTrue(isValidCarNumber("K222PK169"));
        assertTrue(isValidCarNumber("T222EO100"));
    }

    @Test
    void isValidCarNumberInvalidTest() {
        ;
        assertFalse(isValidCarNumber(""));
        ;
        assertFalse(isValidCarNumber("123DD"));
        ;
        assertFalse(isValidCarNumber("E123H127"));
        ;
        assertFalse(isValidCarNumber("E123&H127"));
        ;
        assertFalse(isValidCarNumber("E123H_27"));
        ;
        assertFalse(isValidCarNumber("E1227"));
        ;
        assertFalse(isValidCarNumber("E123H127"));
        ;
        assertFalse(isValidCarNumber("u123KH127"));
    }
}
