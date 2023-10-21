package edu.project1;

import org.junit.jupiter.api.Test;
import static edu.project1.Main.parseString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParsingTest {
    @Test
    void parseValidInputTest() {
        assertEquals('a', parseString("a"));
        assertEquals('b', parseString("b"));

        assertEquals('c', parseString("C"));
        assertEquals('z', parseString("Z"));
    }

    @Test
    void parseInvalidInputTest() {
        assertNull(parseString("123"));
        assertNull(parseString("qwerty"));
        assertNull(parseString(""));
        assertNull(parseString("12kol,=-"));
        assertNull(parseString("oo"));
        assertNull(parseString("  P     "));
        assertNull(parseString("]"));
    }
}
