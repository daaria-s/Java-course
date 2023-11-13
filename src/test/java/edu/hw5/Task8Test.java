package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task.everyOddSymbolIs1;
import static edu.hw5.Task.numberOf0DividedBy3;
import static edu.hw5.Task.oddLenght;
import static edu.hw5.Task.start0OddLenghtOrStart1EvenLenght;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    void oddLenghtValidTest() {
        assertTrue(oddLenght("0"));
        assertTrue(oddLenght("1"));
        assertTrue(oddLenght("10011"));
        assertTrue(oddLenght("101"));
        assertTrue(oddLenght("1111111"));
        assertTrue(oddLenght("100011100"));
        assertTrue(oddLenght("010101010101010101010"));
    }

    @Test
    void oddLenghtInvalidTest() {
        assertFalse(oddLenght("10"));
        assertFalse(oddLenght("ooo"));
        assertFalse(oddLenght("0000"));
        assertFalse(oddLenght("101010_"));
        assertFalse(oddLenght("111111"));
        assertFalse(oddLenght("10100101011111"));
        assertFalse(oddLenght("101101010111q"));
    }

    @Test
    void start0OddLenghtOrStart1EvenLenghtValidTest() {
        assertTrue(start0OddLenghtOrStart1EvenLenght("000"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("00011"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("0001010"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("0"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("011"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("1000"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("10001010"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("11111111"));
        assertTrue(start0OddLenghtOrStart1EvenLenght("10000011"));
    }

    @Test
    void start0OddLenghtOrStart1EvenLenghtInvalidTest() {
        assertFalse(start0OddLenghtOrStart1EvenLenght("0000"));
        assertFalse(start0OddLenghtOrStart1EvenLenght("10000"));
        assertFalse(start0OddLenghtOrStart1EvenLenght("1"));
        assertFalse(start0OddLenghtOrStart1EvenLenght("00"));
        assertFalse(start0OddLenghtOrStart1EvenLenght("10oo"));
        assertFalse(start0OddLenghtOrStart1EvenLenght("00qwe"));
        assertFalse(start0OddLenghtOrStart1EvenLenght("10****"));
    }

    @Test
    void numberOf0DividedBy3ValidTest() {
        assertTrue(numberOf0DividedBy3("000"));
        assertTrue(numberOf0DividedBy3("1"));
        assertTrue(numberOf0DividedBy3(""));
        assertTrue(numberOf0DividedBy3("000000"));
        assertTrue(numberOf0DividedBy3("000111000111"));
        assertTrue(numberOf0DividedBy3("010101"));
        assertTrue(numberOf0DividedBy3("0011110101001011100"));
        assertTrue(numberOf0DividedBy3("000000000000000"));
    }

    @Test
    void numberOf0DividedBy3InvalidTest() {
        assertFalse(numberOf0DividedBy3("00"));
        assertFalse(numberOf0DividedBy3("0000"));
        assertFalse(numberOf0DividedBy3("000qwerty000"));
        assertFalse(numberOf0DividedBy3("01010101"));
        assertFalse(numberOf0DividedBy3("0001011100101110"));
        assertFalse(numberOf0DividedBy3("0ooooo"));
    }

    @Test
    void everyOddSymbolIs1ValidTest() {
        assertTrue(everyOddSymbolIs1("01"));
        assertTrue(everyOddSymbolIs1("1111111"));
        assertTrue(everyOddSymbolIs1("01010111111"));
        assertTrue(everyOddSymbolIs1("01010"));
        assertTrue(everyOddSymbolIs1("01110"));
        assertTrue(everyOddSymbolIs1("1101011101110"));
    }

    @Test
    void everyOddSymbolIs1InvalidTest() {

        assertFalse(everyOddSymbolIs1("000"));
        assertFalse(everyOddSymbolIs1("o1o1o1qwerty"));
        assertFalse(everyOddSymbolIs1("java"));
        assertFalse(everyOddSymbolIs1("hello_world"));
        assertFalse(everyOddSymbolIs1("0000000000000000000"));
        assertFalse(everyOddSymbolIs1("101010101010"));
    }

}
