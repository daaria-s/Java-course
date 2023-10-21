package edu.project1;

import java.util.Random;

public class Dictionary {

    private final String[] allWords = {"hello", "apple", "mouse", "pizza", "horse", "beach", "steak", "glass", "actor"};
    private final Random rn = new Random();

    public String generateWord() {
        return allWords[rn.nextInt(allWords.length)];

    }
}
