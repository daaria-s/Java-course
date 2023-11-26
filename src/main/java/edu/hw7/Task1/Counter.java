package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.addAndGet(1);
    }

    public int get() {
        return count.get();
    }
}


