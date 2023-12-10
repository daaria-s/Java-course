package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class DfsConcurrent {

    private DfsConcurrent() {}

    static public AtomicBoolean[] dfs(int start, Map<Integer, int[]> graph, int threadsNumber) {
        AtomicBoolean[] isVisited = new AtomicBoolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            isVisited[i] = new AtomicBoolean(false);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);

        try {

            return dfsRecursive(start, isVisited, graph, executorService);
        } finally {
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

}
