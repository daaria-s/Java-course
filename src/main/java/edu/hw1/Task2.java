package edu.hw1;

public final class Task2 {

    private static final int BASE = 10;

    private Task2() {
    }

    public static int countDigits(int number) {
        int currentNumber = number;
        int answer = 1;
        while (currentNumber / BASE != 0) {
            ++answer;
            currentNumber /= BASE;
        }
        return answer;

    }
}
