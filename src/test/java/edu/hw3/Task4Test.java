package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    @Test
    void lessThan10Test() {
        assertEquals("I", convertToRoman(1));
        assertEquals("II", convertToRoman(2));
        assertEquals("IV", convertToRoman(4));
        assertEquals("V", convertToRoman(5));
        assertEquals("VI", convertToRoman(6));
        assertEquals("IX", convertToRoman(9));
    }

    @Test
    void lessThan100Test() {
        assertEquals("X", convertToRoman(10));
        assertEquals("XXII", convertToRoman(22));
        assertEquals("XLIX", convertToRoman(49));
        assertEquals("LXIII", convertToRoman(63));
        assertEquals("LXXI", convertToRoman(71));
        assertEquals("LXXXV", convertToRoman(85));
        assertEquals("XCIX", convertToRoman(99));
    }

    @Test
    void lessThan1000Test() {
        assertEquals("C", convertToRoman(100));
        assertEquals("CCXXVI", convertToRoman(226));
        assertEquals("CDXCI", convertToRoman(491));
        assertEquals("DCXXX", convertToRoman(630));
        assertEquals("DCCXVIII", convertToRoman(718));
        assertEquals("DCCCLV", convertToRoman(855));
        assertEquals("CMXCIX", convertToRoman(999));
    }

    @Test
    void lessThan4000Test() {
        assertEquals("M", convertToRoman(1000));
        assertEquals("MMCCLX", convertToRoman(2260));
        assertEquals("MMMCMXIII", convertToRoman(3913));
        assertEquals("MMMCMXCIX", convertToRoman(3999));
    }
}
