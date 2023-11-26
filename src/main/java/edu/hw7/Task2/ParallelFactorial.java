package edu.hw7.Task2;

import java.util.stream.IntStream;

public class ParallelFactorial {

    private ParallelFactorial() {
    }

    public static int factorial(int n) {
        return IntStream.rangeClosed(1, n).parallel().reduce(
            1,
            (a, b) -> a * b
        );
    }

}
