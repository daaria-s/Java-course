package edu.project2;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static edu.project2.Renderer.render;
import static edu.project2.Solver.solveWithBfs;
import static edu.project2.SolverTest.readMazeFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RendererTest {

    @Test
    void rendererWithPathTest() {
        Maze maze = new Maze(
            3,
            3,
            new Cell[][] {
                {new Cell(0, 0, Cell.Type.WALL), new Cell(0, 0, Cell.Type.WALL), new Cell(0, 0, Cell.Type.WALL)},
                {new Cell(0, 0, Cell.Type.WALL), new Cell(0, 0, Cell.Type.PASSAGE), new Cell(0, 0, Cell.Type.WALL)},
                {new Cell(0, 0, Cell.Type.WALL), new Cell(0, 0, Cell.Type.PASSAGE), new Cell(0, 0, Cell.Type.WALL)}}
        );

        ArrayList<Coordinate> path = new ArrayList<>();
        assertThrows(AssertionError.class, () -> render(maze, path));
    }

    @Test
    void renderOutputTest() {
        Maze maze = readMazeFromFile("mazeWithManySolutions.txt");
        String renderResult = render(maze);
        assertEquals(readFromFile("prettyOutputMaze.txt"), renderResult);
    }

    @Test
    void renderWithPathOutputTest() {
        Maze maze = readMazeFromFile("mazeWithManySolutions.txt");
        String renderResult = render(maze, solveWithBfs(maze, new Coordinate(1, 1), new Coordinate(9, 1)));
        assertEquals(readFromFile("prettyOutputMazeWithSolution.txt"), renderResult);
    }

    String readFromFile(String fileName) {

        StringBuilder expectedResult = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                expectedResult.append(reader.readLine());
                expectedResult.append('\n');
            }

            return expectedResult.toString();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return null;
    }

}
