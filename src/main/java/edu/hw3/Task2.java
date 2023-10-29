package edu.hw3;

import java.util.ArrayList;

class Task2 {

    private Task2() {}

    static public ArrayList<String> clusterize(String string) {
        ArrayList<String> answer = new ArrayList<>();
        int currentOpenBrackets = 0;
        int lastUsedIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                currentOpenBrackets++;
            } else if (string.charAt(i) == ')') {
                currentOpenBrackets--;
            }

            if (currentOpenBrackets == 0) {
                answer.add(string.substring(lastUsedIndex, i + 1));
                lastUsedIndex = i + 1;
            }
        }

        return answer;
    }

}
