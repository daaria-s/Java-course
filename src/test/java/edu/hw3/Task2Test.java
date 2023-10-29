package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;

import static edu.hw3.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    void clusterizeTest() {
        assertEquals(List.of("()", "()", "()"), clusterize("()()()"));
        assertEquals(List.of("((()))"), clusterize("((()))"));
        assertEquals(List.of("((()))", "(())", "()", "()", "(()())"), clusterize("((()))(())()()(()())"));
        assertEquals(List.of("((())())", "(()(()()))"), clusterize("((())())(()(()()))"));
    }

    @Test
    void clusterizeEmptyInputTest() {
        assertEquals(List.of(), clusterize(""));
    }
}
