package edu;

public class FractalImage {

    Pixel[][] data;
    int width;
    int height;

    FractalImage(Pixel[][] data, int width, int height) {
        this.data = data;
        this.width = width;
        this.height = height;

    }

    FractalImage(int width, int height) {
        this.data = new Pixel[width][height];
        this.width = width;
        this.height = height;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                data[x][y] = new Pixel(0, 0, 0, 0);
            }
        }
    }

    boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    Pixel pixel(int x, int y) {
        return data[x][y];
    }

    void updatePixel(int x, int y, Pixel pixel) {
        if (contains(x, y)) {
            data[x][y] = pixel;
        }
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
