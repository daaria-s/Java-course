package edu;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {
    }

    enum ImageFormat { JPEG, BMP, PNG }

    static void save(FractalImage image, String filename, ImageFormat format) {

        BufferedImage bufferedImage = new BufferedImage(
            image.width(),
            image.height(),
            BufferedImage.TYPE_INT_RGB
        );

        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                Pixel pixel = image.pixel(x, y);
                Color col = new Color(pixel.r(), pixel.g(), pixel.b());
                bufferedImage.setRGB(x, y, col.getRGB());
            }
        }

        try {
            File file = new File(filename);
            ImageIO.write(bufferedImage, format.name().toLowerCase(), file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
