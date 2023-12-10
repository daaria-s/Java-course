package edu.hw9.Task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatsCollector {
    ConcurrentHashMap<String, double[]> metricsData;

    public StatsCollector() {
        metricsData = new ConcurrentHashMap<>();

    }

    public void push(String name, double[] data) {
        metricsData.put(name, data);
    }

    public Map<String, MetricStats> stats() {
        Map<String, MetricStats> answer = new HashMap<>();

        for (var name : metricsData.keySet()) {

            double[] metric = metricsData.get(name);

            double sum = Arrays.stream(metric).sum();

            double average = sum / metric.length;

            double max = Arrays.stream(metric).max().getAsDouble();

            double min = Arrays.stream(metric).min().getAsDouble();

            answer.put(name, new MetricStats(name, sum, average, max, min));
        }
        return answer;
    }

}
