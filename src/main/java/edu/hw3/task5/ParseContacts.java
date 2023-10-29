package edu.hw3.task5;

import java.util.Objects;
import static java.util.Arrays.sort;

public class ParseContacts {

    private ParseContacts() {
    }

    public static Contact[] parseContacts(String[] names, String order) {
        int n = names.length;
        Contact[] answer = new Contact[n];
        for (int i = 0; i < n; i++) {
            answer[i] = new Contact(names[i]);
        }

        if (Objects.equals(order, "ASC")) {
            sort(answer, new ContactComparator());
        } else {
            sort(answer, new ContactComparatorDesc());
        }
        return answer;
    }

}
