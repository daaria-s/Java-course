package edu.hw1;

import edu.hw1.Task4;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void validTest() {
        assertEquals(edu.hw1.Task4.fixString("оПомигети псаривьтс ртко!и"), "Помогите исправить строки!");
        assertEquals(edu.hw1.Task4.fixString("123456"), "214365");
        assertEquals(edu.hw1.Task4.fixString("hTsii  s aimex dpus rtni.g"), "This is a mixed up string.");
        assertEquals(edu.hw1.Task4.fixString("badce"), "abcde");
        assertEquals(edu.hw1.Task4.fixString("a"), "a");
    }

    @Test
    void randomTest() {
        Random rn = new Random();
        for (int i = 0; i < 100; i++) {
            int size = rn.nextInt(10000);
            byte[] array = new byte[size];
            rn.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            assertEquals(edu.hw1.Task4.fixString(Task4.fixString(generatedString)), generatedString);
        }


    }
}
