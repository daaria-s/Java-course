package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;

class Task3 {
    private Task3() {}

    public static <T> HashMap<T, Integer> freqDict(ArrayList<T> arrayList) {
        HashMap<T, Integer> answer = new HashMap<>();
        for (T elem : arrayList) {
            if (answer.containsKey(elem)) {
                answer.put(elem, answer.get(elem) + 1);
            } else {
                answer.put(elem, 1);
            }
        }
        return answer;

    }

}
