package edu;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Renderer {

    private Renderer() {
    }

    static FractalImage renderConcurrent(
        FractalImage canvas,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        int symmetry,
        int threadsNumber
    ) {
        Runnable onePixel = () -> {
            Point pw;
            double x = ThreadLocalRandom.current().nextDouble(-1, 1);
            double y = ThreadLocalRandom.current().nextDouble(-1, 1);
            pw = new Point(x, y);

            for (short step = 0; step < iterPerSample; ++step) {
                Transformation variation = variations.get(ThreadLocalRandom.current().nextInt(variations.size()));

                pw = variation.apply(pw);

                double theta2 = 0.0;
                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {

                    var pwr = rotate(pw, theta2);

                    pwr = new Point((pwr.x() + 1) * canvas.width() / 2, (pwr.y() + 1) * canvas.height() / 2);

                    int newX = (int) pwr.x();
                    int newY = (int) pwr.y();

                    if (!canvas.contains(newX, newY)) {
                        continue;
                    }

                    Pixel pixel = generatePixel(canvas, newX, newY, variation);

                    synchronized (canvas.pixel(newX, newY)) {
                        canvas.updatePixel(newX, newY, pixel);

                    }

                }
            }

        };

        ExecutorService executor = Executors.newFixedThreadPool(threadsNumber);
        for (int i = 0; i < samples; i++) {
            executor.execute(onePixel);
        }

        executor.shutdown();
        executor.close();
        return canvas;
    }

    private static Pixel generatePixel(FractalImage canvas, int newX, int newY, Transformation variation) {
        int r;
        int g;
        int b;
        if (canvas.pixel(newX, newY).hitCount() == 0) {
            r = variation.r();
            g = variation.g();
            b = variation.b();
        } else {
            r = (canvas.pixel(newX, newY).r() + variation.r()) / 2;
            g = (canvas.pixel(newX, newY).g() + variation.g()) / 2;
            b = (canvas.pixel(newX, newY).b() + variation.b()) / 2;
        }

        return new Pixel(
            r,
            g,
            b,
            canvas.pixel(newX, newY).hitCount() + 1
        );
    }

    private static Point rotate(Point point, double angle) {
        double x = point.x() * Math.cos(angle) + point.y() * Math.sin(angle);
        double y = -point.x() * Math.sin(angle) + point.y() * Math.cos(angle);
        return new Point(x, y);
    }

}
