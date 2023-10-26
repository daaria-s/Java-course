package edu.hw3;


public class Task1 {


    static final char UPPER_A = 'A';
    static final char UPPER_Z = 'Z';

    static final char LOWER_A = 'a';
    static final char LOWER_Z = 'z';

    public static String atbash(String string) {
        int n = string.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char currentChar = string.charAt(i);
            if (currentChar >= UPPER_A && currentChar <= UPPER_Z) {
                currentChar = (char) ( UPPER_Z -(currentChar - UPPER_A));
            }
            else if (currentChar >= LOWER_A && currentChar <= LOWER_Z) {
                currentChar = (char) ( LOWER_Z -(currentChar - LOWER_A));
            }
            answer.append(currentChar);
        }
    return answer.toString();
    }


    public static void main(String[] s) {
        assert  atbash("Hello world!").equals("Svool dliow!");
    }
}
