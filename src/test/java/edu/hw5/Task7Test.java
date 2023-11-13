package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task.lenghtAtLeast3And0IsThird;
import static edu.hw5.Task.lengthFrom1To3;
import static edu.hw5.Task.startsAndEndsWithSameSymbol;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    void lenghtAtLeast3And0IsThirdValidTest() {
        assertTrue(lenghtAtLeast3And0IsThird("000"));
        assertTrue(lenghtAtLeast3And0IsThird("100"));
        assertTrue(lenghtAtLeast3And0IsThird("010"));
        assertTrue(lenghtAtLeast3And0IsThird("110"));
        assertTrue(lenghtAtLeast3And0IsThird("1000101"));
        assertTrue(lenghtAtLeast3And0IsThird("0001111"));
        assertTrue(lenghtAtLeast3And0IsThird("110110"));
        assertTrue(lenghtAtLeast3And0IsThird("100010101010101"));
    }

    @Test
    void lenghtAtLeast3And0IsThirdInvalidTest() {
        assertFalse(lenghtAtLeast3And0IsThird(""));
        assertFalse(lenghtAtLeast3And0IsThird("0"));
        assertFalse(lenghtAtLeast3And0IsThird("1"));
        assertFalse(lenghtAtLeast3And0IsThird("10"));
        assertFalse(lenghtAtLeast3And0IsThird("11"));
        assertFalse(lenghtAtLeast3And0IsThird("01"));
        assertFalse(lenghtAtLeast3And0IsThird("011**111"));
        assertFalse(lenghtAtLeast3And0IsThird("00!!1000"));
        assertFalse(lenghtAtLeast3And0IsThird("011001"));
        assertFalse(lenghtAtLeast3And0IsThird("11111__111"));
    }

    @Test
    void startsAndEndsWithSameSymbolValidTest() {
        assertTrue(startsAndEndsWithSameSymbol("00"));
        assertTrue(startsAndEndsWithSameSymbol("11"));
        assertTrue(startsAndEndsWithSameSymbol("01110"));
        assertTrue(startsAndEndsWithSameSymbol("100010101011"));
        assertTrue(startsAndEndsWithSameSymbol("0001110001110"));
    }

    @Test
    void startsAndEndsWithSameSymbolInvalidTest() {
        assertFalse(startsAndEndsWithSameSymbol("101010"));
        assertFalse(startsAndEndsWithSameSymbol("00001"));
        assertFalse(startsAndEndsWithSameSymbol("10"));
        assertFalse(startsAndEndsWithSameSymbol("11111110"));
        assertFalse(startsAndEndsWithSameSymbol("10))101"));
        assertFalse(startsAndEndsWithSameSymbol("0000000oooo000"));
    }

    @Test
    void lengthFrom1To3ValidTest() {
        assertTrue(lengthFrom1To3("1"));
        assertTrue(lengthFrom1To3("0"));
        assertTrue(lengthFrom1To3("10"));
        assertTrue(lengthFrom1To3("11"));
        assertTrue(lengthFrom1To3("101"));
        assertTrue(lengthFrom1To3("000"));
        assertTrue(lengthFrom1To3("110"));
    }

    @Test
    void lengthFrom1To3InvalidTest() {
        assertFalse(lengthFrom1To3(""));
        assertFalse(lengthFrom1To3("0000"));
        assertFalse(lengthFrom1To3("1111"));
        assertFalse(lengthFrom1To3("---"));
        assertFalse(lengthFrom1To3("0101010ttt"));
        assertFalse(lengthFrom1To3("otu"));
        assertFalse(lengthFrom1To3("0110110"));
    }
}
