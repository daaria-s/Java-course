package hw1;

public final class Task2 {

    private Task2() {
    }

    public static int countDigits(int number) {
        int answer = 1;
        while (number / 10 != 0) {
            ++answer;
            number /= 10;
        }
        return answer;

    }
}
