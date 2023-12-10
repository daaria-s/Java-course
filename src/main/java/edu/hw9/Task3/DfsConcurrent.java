package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class DfsConcurrent {

    static public AtomicBoolean[] dfs(int start, Map<Integer, int[]> graph, int threadsNumber) {
        System.out.println(graph);
        AtomicBoolean[] isVisited = new AtomicBoolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            isVisited[i] = new AtomicBoolean(false);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);

        try {

            return dfsRecursive(start, isVisited, graph, executorService);
        }
        finally {
            executorService.shutdown();
        }
    }

    static private AtomicBoolean[] dfsRecursive(
        int current,
        AtomicBoolean[] isVisited,
        Map<Integer, int[]> graph,
        ExecutorService executorService
    ) {
        isVisited[current].set(true);

        ArrayList<Future<?>> result = new ArrayList<>();

        for (int dest : graph.get(current)) {

            result.add(executorService.submit(() -> {
                if (!isVisited[dest].get()) {
                    dfsRecursive(dest, isVisited, graph, executorService);
                }
            }));

        }

        while (!result.stream().allMatch(Future::isDone)) {
        }

        return isVisited;
    }

    public static void main(String[] args) {
        Map<Integer, int[]> graph = Map.of(0, new int[] {1, 2},
            1, new int[] {2, 3, 4},
            2, new int[] {},
            3, new int[] {},
            4, new int[] {0}
        );

        AtomicBoolean[] answer = dfs(0, graph, 3);
        System.out.println(Arrays.toString(answer));

    }

}
