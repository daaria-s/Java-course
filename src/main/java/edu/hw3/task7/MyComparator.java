package edu.hw3.task7;

import java.util.Comparator;

public class MyComparator<T extends Comparable> implements Comparator<T> {

    public MyComparator() {
    }

    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }

        if (o1 == null || o2 == null) {
            return -1;
        }

        return o1.compareTo(o2);
    }

}
