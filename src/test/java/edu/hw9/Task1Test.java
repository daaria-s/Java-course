package edu.hw9;

import edu.hw9.Task1.StatsCollector;
import edu.hw9.Task1.MetricStats;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    @Test
    void statsCollectorTest() {

        StatsCollector collector = new StatsCollector();

        Thread thread1 = new Thread(() -> {
            collector.push("metric1", new double[] {0, 0.5, 1, 1.5});
        });

        Thread thread2 = new Thread(() -> {
            collector.push("metric2", new double[] {1, 2, 3, 4});
        });
        Thread thread3 = new Thread(() -> {
            collector.push("metric3", new double[] {-5, -4, -3, -2});
        });
        Thread thread4 = new Thread(() -> {
            collector.push("metric4", new double[] {0, 0, 0, 0});
        });
        Thread thread5 = new Thread(() -> {
            collector.push("metric5", new double[] {0.2, 0.3, 0.4, 0.5});
        });

        Map<String, MetricStats> expected = Map.of("metric1", new MetricStats("metric1", 3, 0.75, 1.5, 0),
            "metric2", new MetricStats("metric2", 10, 2.5, 4, 1),
            "metric3", new MetricStats("metric3", -14, -3.5, -2, -5),
            "metric4", new MetricStats("metric4", 0, 0, 0, 0),
            "metric5", new MetricStats("metric5", 1.4, 0.35, 0.5, 0.2)
        );

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();


            assertEquals(expected.entrySet(), collector.stats().entrySet());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
