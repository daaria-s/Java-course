package edu;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public abstract class Transformation implements Function<Point, Point> {


    static final int RGB_MAX_COLOUR = 255;

    double aCoef;
    double bCoef;
    double cCoef;
    double dCoef;
    double eCoef;
    double fCoef;

    int rColor;
    int gColor;
    int bColor;

    Transformation() {
        while (true) {
            aCoef = ThreadLocalRandom.current().nextDouble(-1, 1);
            bCoef = ThreadLocalRandom.current().nextDouble(-1, 1);
            cCoef = ThreadLocalRandom.current().nextDouble(-1, 1);
            dCoef = ThreadLocalRandom.current().nextDouble(-1, 1);
            eCoef = ThreadLocalRandom.current().nextDouble(-1, 1);
            fCoef = ThreadLocalRandom.current().nextDouble(-1, 1);
            if ((aCoef * aCoef + dCoef * dCoef < 1) && (bCoef * bCoef + eCoef * eCoef < 1)
                && (aCoef * aCoef + bCoef * bCoef + dCoef * dCoef + eCoef * eCoef
                < 1 + (aCoef * eCoef - bCoef * dCoef) * (aCoef * eCoef - bCoef * dCoef))) {
                generateColour();
                return;
            }
        }
    }

    public Point apply(Point point) {
        return doNonlinearTransformation(doLinearTransformation(point));
    }

    Point doLinearTransformation(Point point) {
        double x = point.x();
        double y = point.y();
        return new Point(aCoef * x + bCoef * y + cCoef, dCoef * x + eCoef * y + fCoef);
    }

    public int r() {
        return rColor;
    }

    public int g() {
        return gColor;
    }

    public int b() {
        return bColor;
    }

    protected abstract Point doNonlinearTransformation(Point point);

    void generateColour() {
        rColor = ThreadLocalRandom.current().nextInt(RGB_MAX_COLOUR);
        gColor = ThreadLocalRandom.current().nextInt(RGB_MAX_COLOUR);
        bColor = ThreadLocalRandom.current().nextInt(RGB_MAX_COLOUR);

    }
}
