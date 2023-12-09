package edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FractalImageTest {

    int width = 5;
    int height = 5;

    @Test
    void ConstructorTest() {

        Pixel pixel = new Pixel(0, 0, 0, 0);

        FractalImage image = new FractalImage(width, height);

        assertEquals(width, image.width);
        assertEquals(height, image.height);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                assertEquals(pixel, image.pixel(i, j));
            }
        }

    }

    @Test
    void updatePixelTest() {

        FractalImage image = new FractalImage(width, height);

        Pixel pixel12 = new Pixel(100, 1, 255, 0);
        image.updatePixel(1, 2, pixel12);

        assertEquals(pixel12, image.pixel(1, 2));

        Pixel pixel44 = new Pixel(255, 255, 255, 0);
        image.updatePixel(4, 4, pixel44);

        assertEquals(pixel44, image.pixel(4, 4));

        Pixel pixel31 = new Pixel(100, 100, 0, 0);
        image.updatePixel(3, 1, pixel31);

        assertEquals(pixel31, image.pixel(3, 1));
    }

    @Test
    void containsPixelTest() {
        FractalImage image = new FractalImage(width, height);

        assertTrue(image.contains(0, 0));
        assertTrue(image.contains(0, 3));
        assertTrue(image.contains(2, 1));
        assertTrue(image.contains(4, 4));

        assertFalse(image.contains(5, 5));
        assertFalse(image.contains(-1, -1));
        assertFalse(image.contains(0, 100));
        assertFalse(image.contains(20, 3));

    }
}
