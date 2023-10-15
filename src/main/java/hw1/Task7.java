package hw1;

public final class Task7 {

    private Task7() {
    }


    private static int numberOfBits(int n) {
        int answer = 0;
        while (n > 0) {
            n /= 2;
            answer++;
        }
        return answer;
    }

    public static int rotateLeft(int n, int shift) {
        int numberOfBits = numberOfBits(n);
        shift %= numberOfBits;
        return rotateRight(n, numberOfBits - shift);
    }

    public static int rotateRight(int n, int shift) {
        int numberOfBits = numberOfBits(n);
        shift %= numberOfBits;
        return (n >> shift) | (n % (1 << shift) << (numberOfBits - shift));
    }


    public static void main(String[] arg) {

    }
}
