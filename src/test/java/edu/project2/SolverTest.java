package edu.project2;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static edu.project2.Solver.solveWithBackTracking;
import static edu.project2.Solver.solveWithBfs;

public class SolverTest {

    static Maze mazeWithOneSolution = readMazeFromFile("mazeWithOneSolution.txt");

    static Maze mazeWithManySolutions = readMazeFromFile("mazeWithManySolutions.txt");

    ArrayList<Coordinate> mySolutionFrom11To99 = readSolutionfromFile("solution11to99.txt");
    ArrayList<Coordinate> mySolutionFrom11To55 = readSolutionfromFile("solution11to55.txt");

    Coordinate coordinate11 = new Coordinate(1, 1);

    Coordinate coordinate99 = new Coordinate(9, 9);

    Coordinate coordinate55 = new Coordinate(5, 5);

    Coordinate coordinate51 = new Coordinate(5, 1);

    ArrayList<Coordinate> readSolutionfromFile(String fileName) {
        try {
            ArrayList<Coordinate> result = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            while (reader.ready()) {
                line = reader.readLine();
                String[] coordinate = line.split(" ");
                result.add(new Coordinate(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1])));
            }
            return result;

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return null;
    }

    static Maze readMazeFromFile(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String size = reader.readLine();

            String[] splittedSize = size.split(" ");
            int height = Integer.parseInt(splittedSize[0]);
            int width = Integer.parseInt(splittedSize[1]);

            Cell[][] grid = new Cell[height][width];

            for (int i = 0; i < height; i++) {
                String line = reader.readLine();
                for (int j = 0; j < width; j++) {
                    if (line.charAt(j) == '⬜') {
                        grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
                    } else {
                        grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                    }
                }
            }
            return new Maze(height, width, grid);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return null;

    }

    @Test
    void solveWithBfsTest() {
        Assertions.assertEquals(mySolutionFrom11To99, solveWithBfs(mazeWithOneSolution, coordinate11, coordinate99));
        Assertions.assertEquals(mySolutionFrom11To55, solveWithBfs(mazeWithOneSolution, coordinate11, coordinate55));

        Assertions.assertFalse(solveWithBfs(mazeWithManySolutions, coordinate11, coordinate55).isEmpty());
        Assertions.assertTrue(solveWithBfs(mazeWithManySolutions, coordinate11, coordinate51).isEmpty());
        Assertions.assertTrue(solveWithBfs(mazeWithManySolutions, coordinate51, coordinate99).isEmpty());

    }

    @Test
    void solveWithBackTrackingTest() {

        Assertions.assertEquals(mySolutionFrom11To99, solveWithBackTracking(mazeWithOneSolution, coordinate11, coordinate99));
        Assertions.assertEquals(mySolutionFrom11To55, solveWithBackTracking(mazeWithOneSolution, coordinate11, coordinate55));

        Assertions.assertFalse(solveWithBackTracking(mazeWithManySolutions, coordinate11, coordinate55).isEmpty());
        Assertions.assertTrue(solveWithBackTracking(mazeWithManySolutions, coordinate11, coordinate51).isEmpty());
        Assertions.assertTrue(solveWithBackTracking(mazeWithManySolutions, coordinate51, coordinate99).isEmpty());

    }



}
