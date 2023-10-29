package edu.hw3.task5;

import java.util.Comparator;

class ContactComparator implements Comparator<Contact> {

    public int result(int value) {
        return value;
    }

    public int compare(Contact a, Contact b) {
        String aCompare;
        String bCompare;
        if (a.surname != null) {
            aCompare = a.surname;
        } else {
            aCompare = a.name;
        }
        if (b.surname != null) {
            bCompare = b.surname;
        } else {
            bCompare = b.name;
        }
        return result(aCompare.compareTo(bCompare));

    }
}
