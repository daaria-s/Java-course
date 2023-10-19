package edu.hw1;

import edu.hw1.Task4;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void validTest() {
        assertEquals("Помогите исправить строки!", edu.hw1.Task4.fixString("оПомигети псаривьтс ртко!и"));
        assertEquals("214365", edu.hw1.Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", edu.hw1.Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", edu.hw1.Task4.fixString("badce"));
        assertEquals("a", edu.hw1.Task4.fixString("a"));
    }

    @Test
    void randomTest() {
        Random rn = new Random();
        for (int i = 0; i < 100; i++) {
            int size = rn.nextInt(10000);
            byte[] array = new byte[size];
            rn.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            assertEquals(generatedString, edu.hw1.Task4.fixString(Task4.fixString(generatedString)));
        }


    }
}
