package hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Task4Test {
    @Test
    void validTest() {
        assertEquals(Task4.fixString("оПомигети псаривьтс ртко!и"), "Помогите исправить строки!");
        assertEquals(Task4.fixString("123456"), "214365");
        assertEquals(Task4.fixString("hTsii  s aimex dpus rtni.g"), "This is a mixed up string.");
        assertEquals(Task4.fixString("badce"), "abcde");
        assertEquals(Task4.fixString("a"), "a");
    }

    @Test
    void randomTest() {
        Random rn = new Random();
        for (int i = 0; i < 100; i++) {
            int size = rn.nextInt(10000);
            byte[] array = new byte[size];
            rn.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            assertEquals(Task4.fixString(Task4.fixString(generatedString)), generatedString);
        }


    }
}
