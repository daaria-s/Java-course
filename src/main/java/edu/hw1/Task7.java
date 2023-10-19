package edu.hw1;

public final class Task7 {

    private Task7() {
    }


    private static int numberOfBits(int n) {
        int answer = 0;
        int number = n;
        while (number > 0) {
            number /= 2;
            answer++;
        }
        return answer;
    }

    public static int rotateLeft(int n, int shift) {
        int currentShift = shift;
        int numberOfBits = numberOfBits(n);
        currentShift %= numberOfBits;
        return rotateRight(n, numberOfBits - currentShift);
    }

    public static int rotateRight(int n, int shift) {
        int currentShift = shift;
        int numberOfBits = numberOfBits(n);
        currentShift %= numberOfBits;
        return (n >> currentShift) | (n % (1 << currentShift) << (numberOfBits - currentShift));
    }

}
