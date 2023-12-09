package edu;

import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class TransformationHeart extends Transformation {

    @Override
    protected Point doNonlinearTransformation(Point point) {
        double sqrt = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double newX = sqrt * sin(sqrt * atan(point.y() / point.x()));
        double newY = -sqrt * cos(sqrt * atan(point.y() / point.x()));
        return new Point(newX, newY);
    }
}
