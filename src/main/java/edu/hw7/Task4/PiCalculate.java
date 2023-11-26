package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculate {

    private PiCalculate() {
    }

    static final double VALUE_FOR_PI_COUNT = 4.0;

    public static double piCalculating(int numberOfThreads, int totalCount) {

        AtomicInteger circleCount = new AtomicInteger(0);

        ArrayList<Thread> threads = new ArrayList<>();

        for (int j = 0; j < numberOfThreads; j++) {
            threads.add(new Thread(() -> {
                int localCircleCount = 0;
                for (int i = 0; i < totalCount / numberOfThreads; i++) {
                    double x = ThreadLocalRandom.current().nextDouble(-1, 1);
                    double y = ThreadLocalRandom.current().nextDouble(-1, 1);
                    if (x * x + y * y < 1) {
                        localCircleCount++;
                    }
                }
                circleCount.addAndGet(localCircleCount);
            }));
        }

        for (var thread : threads) {
            thread.start();
        }

        try {

            for (var thread : threads) {
                thread.join();
            }

            return VALUE_FOR_PI_COUNT * circleCount.get() / totalCount;
        } catch (InterruptedException e) {
            return 0;
        }

    }

    static final Integer[] THREADS_NUMBER = new Integer[] {1, 2, 4, 8};

    static final Integer[] TOTAL_COUNT_NUMBER = new Integer[] {10_000_000, 100_000_000, 1_000_000_000};

    @SuppressWarnings("RegexpSinglelineJava")
    public static void printStatistics() {
        for (var count : TOTAL_COUNT_NUMBER) {
            for (var threads : THREADS_NUMBER) {
                System.out.println("Threads: " + threads + ", totalCount: " + count);
                long startTime = System.currentTimeMillis();
                System.out.println("Value: " + piCalculating(threads, count));
                System.out.println("Time: " + (System.currentTimeMillis() - startTime));
            }
            System.out.println("------------------------------------");
        }
    }
}
