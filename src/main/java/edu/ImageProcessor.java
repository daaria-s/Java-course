package edu;

import static java.lang.Math.log10;
import static java.lang.Math.pow;

public
interface ImageProcessor {

    static FractalImage gammaCorrection(FractalImage image) {
        double max = 0.0;
        double gamma = 4.2;
        double[][] normals = new double[image.width()][image.height()];
        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                if (image.pixel(x, y).hitCount() != 0) {
                    normals[x][y] = log10(image.pixel(x, y).hitCount());
                    if (normals[x][y] > max) {
                        max = normals[x][y];
                    }
                }
            }
        }
        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                normals[x][y] /= max;
                int red = (int) (image.pixel(x, y).r() * pow(normals[x][y], (1.0 / gamma)));
                int green = (int) (image.pixel(x, y).g() * pow(normals[x][y], (1.0 / gamma)));
                int blue = (int) (image.pixel(x, y).b() * pow(normals[x][y], (1.0 / gamma)));
                image.updatePixel(x, y, new Pixel(red, green, blue, image.pixel(x, y).hitCount()));
            }
        }
        return image;
    }
}
