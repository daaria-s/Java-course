package edu;

import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static edu.ImageUtils.save;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageUtilsTest {

    String testImage = "testImage.png";
    FractalImage readImage() {

        try {
            File file = new File(testImage);
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();


            Pixel[][] result = new Pixel[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int color = image.getRGB(i, j);
                    result[i][j] = new Pixel((color & 0xff0000) >> 16, (color & 0xff00) >> 8, color & 0xff, 0);

                }
            }

            return new FractalImage(result, width, height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    boolean isEquals(String image1, String image2) {
        try {
            File file1 = new File(image1);
            BufferedImage bufferedImage1 = ImageIO.read(file1);

            File file2 = new File(image2);
            BufferedImage bufferedImage2 = ImageIO.read(file2);

            int width1 = bufferedImage1.getWidth();
            int height1 = bufferedImage1.getHeight();

            int width2 = bufferedImage2.getWidth();
            int height2 = bufferedImage2.getHeight();

            if (width1 != width2) {
                return false;
            }

            if (height1 != height2) {
                return false;
            }

            for (int i = 0; i < width1; i++) {
                for (int j = 0; j < height1; j++) {
                    if (bufferedImage1.getRGB(i, j) != bufferedImage2.getRGB(i, j)) {
                        return false;
                    }
                }
            }
            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void saveImageTest() {

        FractalImage image = readImage();

        save(image, "actualImage.png", ImageUtils.ImageFormat.PNG);

        assertTrue(isEquals(testImage, "actualImage.png"));

    }
}
