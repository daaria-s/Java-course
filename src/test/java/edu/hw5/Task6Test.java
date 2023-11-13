package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task.isSubsequence;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {

    @Test
    void isSubsequenceValidTest() {
        assertTrue(isSubsequence("abc", "abc"));
        assertTrue(isSubsequence("abc", "aabbcc"));
        assertTrue(isSubsequence("abc", "klnoadfgbouccc"));
        assertTrue(isSubsequence("abc", "a!b**c__"));
        assertTrue(isSubsequence("", "hello"));
        assertTrue(isSubsequence("a", "qwertya"));
        assertTrue(isSubsequence("!!!", "!**!&&!^$#"));
    }

    @Test
    void isSubsequenceInvalidTest() {
        assertFalse(isSubsequence("qwerty", "qwert"));
        assertFalse(isSubsequence("java", ""));
        assertFalse(isSubsequence("JAVA", "java"));
        assertFalse(isSubsequence("123456789", "13579"));
    }
}
