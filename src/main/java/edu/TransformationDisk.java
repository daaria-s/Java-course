package edu;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class TransformationDisk extends Transformation {

    @Override
    protected Point doNonlinearTransformation(Point point) {
        double sqrt = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double newX = 1 / PI * atan(point.y() / point.x()) * sin(PI * sqrt);
        double newY = 1 / PI * atan(point.y() / point.x()) * cos(PI * sqrt);
        return new Point(newX, newY);
    }
}
