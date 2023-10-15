package hw1;

import java.util.Arrays;

public final class Task6 {

    private Task6() {

    }

    private static int countK(int value, int steps) {
        if (value == 6174) {
            return steps;
        }
        int[] values = new int[4];
        for (int i = 0; i < 4; i++) {
            values[i] = value % 10;
            value /= 10;
        }
        Arrays.sort(values);
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer *= 10;
            answer += values[3 - i] - values[i];
        }

        return countK(answer, steps + 1);
    }

    public static int countK(int value) {
        return countK(value, 0);
    }
}
