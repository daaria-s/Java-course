package edu.hw8;

import edu.hw8.Task2.ThreadPool;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {


    int fibonacci(int n) {
        int a1 = 1;
        int a2 = 1;
        int a3;
        for (int i = 2; i < n; i++) {
            a3 = a1 + a2;
            a1 = a2;
            a2 = a3;
        }
        return a2;
    }

    @Test
    void FibonacciThreadPoolTest() {
        ThreadPool threadPool = new ThreadPool(4);

        Runnable fib5 = () -> {
            assertEquals(5, fibonacci(5));
            System.out.println("Assert OK");
        };

        Runnable fib7 = () -> {
            assertEquals(13, fibonacci(7));
            System.out.println("Assert OK");
        };
        Runnable fib10 = () -> {
            assertEquals(55, fibonacci(10));
            System.out.println("Assert OK");
        };

        Runnable fib14 = () -> {
            assertEquals(377, fibonacci(14));
            System.out.println("Assert OK");
        };

        Runnable fib15 = () -> {
            assertEquals(610, fibonacci(15));
            System.out.println("Assert OK");
        };


        threadPool.execute(fib5);
        threadPool.execute(fib7);
        threadPool.execute(fib10);
        threadPool.execute(fib14);
        threadPool.execute(fib15);
        threadPool.start();
    }
}
