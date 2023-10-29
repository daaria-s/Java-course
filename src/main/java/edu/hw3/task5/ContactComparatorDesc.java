package edu.hw3.task5;

class ContactComparatorDesc extends ContactComparator {

    @Override
    public int result(int value) {
        return -1 * value;
    }

}
