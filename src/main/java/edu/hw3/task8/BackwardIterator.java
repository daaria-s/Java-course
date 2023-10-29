package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardIterator<E> implements Iterator<E> {

    int cursor;
    E[] myCollection;

    public BackwardIterator(Collection<E> collection) {
        this.cursor = collection.size();
        this.myCollection = (E[]) collection.toArray();
    }

    @Override
    public boolean hasNext() {
        return cursor != 0;

    }

    @Override
    public E next() {
        if (hasNext()) {
            cursor--;
            return myCollection[cursor];
        }
        throw new NoSuchElementException();
    }
}

