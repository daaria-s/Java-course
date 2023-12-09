package edu;

public class TransformationSphere extends Transformation {

    @Override
    protected Point doNonlinearTransformation(Point p) {
        double r = p.x() * p.x() + p.y() * p.y();
        return new Point(p.x() / r, p.y() / r);
    }

}
