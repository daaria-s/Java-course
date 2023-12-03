package edu.hw8.Task2;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool implements AutoCloseable {

    private final int threadsNumber;
    private final Thread[] threads;
    private final LinkedBlockingQueue<Runnable> queue;


    public ThreadPool(int threadsNumber) {
        this.threadsNumber = threadsNumber;
        queue = new LinkedBlockingQueue<>();
        threads = new Thread[threadsNumber];
    }

    @SuppressWarnings("InnerAssignment")
    public void start() {
        for (int i = 0; i < threadsNumber; i++) {
            threads[i] = new Thread(() -> {
                Runnable task;
                synchronized (queue) {
                    while (true) {
                        if ((task = queue.poll()) != null) {
                            task.run();
                        } else {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            });
            threads[i].start();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }

    @Override
    public void close() {
        for (int i = 0; i < threadsNumber; i++) {
            if (threads[i] != null) {
                threads[i].interrupt();
            }
        }

    }
}
