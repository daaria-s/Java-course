package edu.hw3;

public class Task4 {

    private final static String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final static int[] DECIMAL_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String convertToRoman(int number) {
        var answer = new StringBuilder();
        int remaining = number;
        for (int i = 0; i < ROMAN_NUMBERS.length; i++) {
            int decimalNumber = DECIMAL_NUMBERS[i];
            String romanNumber = ROMAN_NUMBERS[i];
            while (remaining >= decimalNumber) {
                answer.append(romanNumber);
                remaining -= decimalNumber;
            }
        }
        return answer.toString();
    }





    public static void main(String[] s) {
        System.out.println(convertToRoman(27));
    }
}
