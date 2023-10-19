package edu.hw1;

public final class Task5 {

    private Task5() {

    }

    private static boolean isPalindrome(String value) {
        String reversedStringValue = new StringBuilder(value).reverse().toString();
        return value.equals(reversedStringValue);
    }

    public static boolean isPalindromeDescendant(int value) {
        String stringValue = Integer.toString(value);
        while (stringValue.length() != 1) {
            if (isPalindrome(stringValue)) {
                return true;
            }
            if (stringValue.length() % 2 != 0) {
                return false;
            }
            StringBuilder nextString = new StringBuilder();
            for (int i = 0; i < stringValue.length(); i += 2) {
                nextString.append((int) stringValue.charAt(i) - '0' + stringValue.charAt(i + 1) - '0');
            }
            stringValue = String.valueOf(nextString);
        }

        return false;
    }

}
