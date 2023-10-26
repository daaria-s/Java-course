package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;

public class Task3 {

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

    public static void main(String[] s) {
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("BB");
        a.add("a");
        a.add("BB");
        HashMap<String, Integer> dic = freqDict(a);
        System.out.println(dic);
    }
    }
