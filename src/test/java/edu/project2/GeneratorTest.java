package edu.project2;

import org.junit.jupiter.api.Test;
import static edu.project2.Generator.generateWithDfs;
import static edu.project2.Generator.generateWithPrimaAlgorithm;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeneratorTest {

    private GeneratorTest() {
    }

    @Test
    void generateWithDfsTest() {
        assertThrows(AssertionError.class, () -> generateWithDfs(-1, 2));
        assertThrows(AssertionError.class, () -> generateWithDfs(2, -1));
        assertThrows(AssertionError.class, () -> generateWithDfs(0, 0));

    }

    @Test
    void generateWithPrimaAlgorithmTest() {
        assertThrows(AssertionError.class, () -> generateWithPrimaAlgorithm(-1, 2));
        assertThrows(AssertionError.class, () -> generateWithPrimaAlgorithm(2, -1));
        assertThrows(AssertionError.class, () -> generateWithPrimaAlgorithm(0, 0));

    }
}
