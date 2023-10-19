package edu.hw1;

import java.util.Arrays;

public final class Task6 {

    private static final int RESULT_NUMBER = 6174;
    private static final int NUMBER_OF_DIGITS = 4;
    private static final int BASE = 10;

    private Task6() {
    }

    private static int countK(int value, int steps) {
        int currentValue = value;
        if (currentValue == RESULT_NUMBER) {
            return steps;
        }
        int[] values = new int[NUMBER_OF_DIGITS];
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            values[i] = currentValue % BASE;
            currentValue /= BASE;
        }
        Arrays.sort(values);
        int answer = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            answer *= BASE;
            answer += values[NUMBER_OF_DIGITS - 1 - i] - values[i];
        }

        return countK(answer, steps + 1);
    }

    public static int countK(int value) {
        return countK(value, 0);
    }
}
