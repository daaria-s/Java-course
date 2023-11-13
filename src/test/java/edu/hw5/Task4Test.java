package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task.passwordContainsSymbols;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    void passwordContainsSymbolsValidTest() {
        assertTrue(passwordContainsSymbols("12345!"));
        assertTrue(passwordContainsSymbols("123~45"));
        assertTrue(passwordContainsSymbols("@12345"));
        assertTrue(passwordContainsSymbols("12#345"));
        assertTrue(passwordContainsSymbols("1234$5"));
        assertTrue(passwordContainsSymbols("123%45"));
        assertTrue(passwordContainsSymbols("1^2345"));
        assertTrue(passwordContainsSymbols("12&345"));
        assertTrue(passwordContainsSymbols("123*45"));
        assertTrue(passwordContainsSymbols("|12345"));
    }

    @Test
    void passwordContainsSymbolsOneSymbolTest() {
        assertTrue(passwordContainsSymbols("!"));
        assertTrue(passwordContainsSymbols("~"));
        assertTrue(passwordContainsSymbols("@"));
        assertTrue(passwordContainsSymbols("#"));
        assertTrue(passwordContainsSymbols("$"));
        assertTrue(passwordContainsSymbols("%"));
        assertTrue(passwordContainsSymbols("^"));
        assertTrue(passwordContainsSymbols("&"));
        assertTrue(passwordContainsSymbols("*"));
        assertTrue(passwordContainsSymbols("|"));
    }

    @Test
    void passwordContainsSymbolsInvalidTest() {
        assertFalse(passwordContainsSymbols("qwerty"));
        assertFalse(passwordContainsSymbols(""));
        assertFalse(passwordContainsSymbols("0987654321"));
        assertFalse(passwordContainsSymbols("---+++"));
        assertFalse(passwordContainsSymbols("[\\]"));
    }
}
