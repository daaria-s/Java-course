package edu.hw7.Task1;

public class ThreadSafeCount {

    private ThreadSafeCount() {}

    public static int threadSafeCount(int n) {
        Counter counter = new Counter();
        int value1 = n / 2;
        int value2 = n - value1;

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < value1; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < value2; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            return counter.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
