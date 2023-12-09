package edu;

import static java.lang.Math.sin;

public class TransformationSin extends Transformation {

    @Override protected Point doNonlinearTransformation(Point point) {
        return new Point(sin(point.x()), sin(point.y()));
    }

}
