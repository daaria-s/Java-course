package edu;

import java.util.List;
import java.util.Random;
import static edu.ImageProcessor.gammaCorrection;
import static edu.ImageUtils.ImageFormat.PNG;
import static edu.Renderer.renderConcurrent;

public class Main {

    private Main() {
    }

    static final int WIDTH = 2000;
    static final int HEIGHT = 2000;
    static final int SAMPLES = 500000;
    static final int ITER_PER_SAMPLE = 800;

    static final int SYMMETRY = 1;

    static final String NAME = "fractal";

    static final ImageUtils.ImageFormat IMAGE_FORMAT = PNG;

    static final int[] THREADS_NUMBERS = new int[] {1, 2, 4, 8};

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) {

        List<Transformation> allTransformations = List.of(
            new TransformationSin(),
            new TransformationSin(),
            new TransformationSin(),
            new TransformationSphere(),
            new TransformationSphere(),
            new TransformationSphere(),
            new TransformationSphere(),
            new TransformationHeart(),
            new TransformationHeart(),
            new TransformationDisk(),
            new TransformationDisk(),
            new TransformationDisk()
        );

        Random random = new Random();

        for (int i : THREADS_NUMBERS) {

            System.out.println("Choosing transformations....");

            List<Transformation> transformations = List.of(
                allTransformations.get(random.nextInt(allTransformations.size())),
                allTransformations.get(random.nextInt(allTransformations.size())),
                allTransformations.get(random.nextInt(allTransformations.size())),
                allTransformations.get(random.nextInt(allTransformations.size()))
            );

            System.out.println("Generating image....");

            long startTime = System.currentTimeMillis();

            FractalImage result =
                renderConcurrent(
                    new FractalImage(WIDTH, HEIGHT),
                    transformations,
                    SAMPLES,
                    Main.ITER_PER_SAMPLE,
                    SYMMETRY,
                    i
                );

            System.out.println("Generation time: " + (System.currentTimeMillis() - startTime));
            System.out.println("Treads number: " + i);

            String fileName = NAME + i + "." + IMAGE_FORMAT.toString().toLowerCase();
            String fileNameWithCorrection =
                NAME + "WithCorrection" + i + "." + IMAGE_FORMAT.toString().toLowerCase();

            ImageUtils.save(result, fileName, IMAGE_FORMAT);
            ImageUtils.save(
                gammaCorrection(result),
                fileNameWithCorrection,
                IMAGE_FORMAT
            );
            System.out.println("Generated image in file " + fileName);
            System.out.println("Generated image with gamma correction in file " + fileNameWithCorrection);
            System.out.println();

        }
    }
}
