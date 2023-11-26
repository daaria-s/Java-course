package edu.hw7;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static edu.hw7.Task4.PiCalculate.piCalculating;
import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task4Test {

    @Test
    void piCalculate_1Thread_10000000Counts() {
        double pi = piCalculating(1, 10000000);
        assertTrue(abs(pi - Math.PI) < 0.009);
    }

    @Test
    void piCalculate_2Threads_10000000Counts() {
        double pi = piCalculating(2, 10000000);
        assertTrue(abs(pi - Math.PI) < 0.009);
    }

    @Test
    void piCalculate_4Threads_10000000Counts() {
        double pi = piCalculating(4, 10000000);
        assertTrue(abs(pi - Math.PI) < 0.009);
    }

    @Test
    void piCalculate_8Threads_10000000Counts() {
        double pi = piCalculating(8, 10000000);
        assertTrue(abs(pi - Math.PI) < 0.009);
    }

    @Test
    void piCalculate_1Thread_100000000Counts() {
        double pi = piCalculating(1, 100000000);
        assertTrue(abs(pi - Math.PI) < 0.0009);
    }

    @Test
    void piCalculate_2Threads_100000000Counts() {
        double pi = piCalculating(2, 100000000);
        assertTrue(abs(pi - Math.PI) < 0.0009);
    }

    @Test
    void piCalculate_4Threads_100000000Counts() {
        double pi = piCalculating(4, 100000000);
        assertTrue(abs(pi - Math.PI) < 0.0009);
    }

    @Test
    void piCalculate_8Threads_100000000Counts() {
        double pi = piCalculating(8, 100000000);
        assertTrue(abs(pi - Math.PI) < 0.0009);
    }

    @Test
    void piCalculate_1Thread_1000000000Counts() {
        double pi = piCalculating(1, 1_000_000_000);
        assertTrue(abs(pi - Math.PI) < 0.00009);
    }

    @Test
    void piCalculate_2Threads_1000000000Counts() {
        double pi = piCalculating(2, 1_000_000_000);
        assertTrue(abs(pi - Math.PI) < 0.0009);
    }

    @Test
    void piCalculate_4Threads_1000000000Counts() {
        double pi = piCalculating(4, 1_000_000_000);
        assertTrue(abs(pi - Math.PI) < 0.00009);
    }

    @Test
    void piCalculate_8Threads_1000000000Counts() {
        double pi = piCalculating(8, 1_000_000_000);
        assertTrue(abs(pi - Math.PI) < 0.00009);
    }

}
