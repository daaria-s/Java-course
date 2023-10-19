package edu.hw1;

public final class Task4 {

    private Task4() {

    }


    public static String fixString(String string) {
        StringBuilder answer = new StringBuilder();
        final int n = string.length();
        for (int i = 0; i < n - 1; i += 2) {
            answer.append(string.charAt(i + 1));
            answer.append(string.charAt(i));
        }
        if (n % 2 != 0) {
            answer.append(string.charAt(n - 1));
        }
        return answer.toString();
    }
}
