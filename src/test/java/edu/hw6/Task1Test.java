package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    @Test
    void diskMapEmptyConstructorTest() {
        File file = new File("diskMap.txt");

        DiskMap diskMap = new DiskMap();
        assertTrue(diskMap.isEmpty());

        assertTrue(file.exists());

        diskMap.put("first", "firstelement");
        diskMap.put("second", "secondelement");
        diskMap.put("third", "thirdelement");

        assertEquals(3, diskMap.size());
        assertTrue(diskMap.containsKey("first"));
        assertTrue(diskMap.containsValue("secondelement"));
        assertEquals("thirdelement", diskMap.get("third"));


        diskMap.remove("third");

        assertFalse(diskMap.containsKey("third"));

        Set<String> expected = new HashSet<>(Arrays.asList("first", "second"));


        assertEquals(expected, diskMap.keySet());

    }

//    Set<Map.Entry<String, String>> readFromFile(File file) {
//
//        Set<Map.Entry<String, String>> result = new HashSet<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            while (reader.ready()) {
//                String[] mapElement = reader.readLine().split(":");
//            }
//        } catch (IOException ignored) {
//        }
//    }

}
