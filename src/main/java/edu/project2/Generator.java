package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class Generator {

    static final int START_TO_FIND_NEIGHBOUR = -2;

    static final int STEP_TO_FIND_NEIGHBOUR = 4;

    static final int[] ROW_MOVE = {-1, 1, 0, 0};
    static final int[] COL_MOVE = {0, 0, -1, 1};

    private Generator() {
    }

    static public Maze generateWithDfs(int givenHeight, int givenWidth) {
        assert givenHeight > 0;
        assert givenWidth > 0;

        int height = givenHeight * 2 + 1;
        int width = givenWidth * 2 + 1;

        Cell[][] grid = createDefaultMaze(height, width);

        HashSet<Coordinate> unvisitedCells = createUnvisitedCellsSet(height, width);

        Coordinate currentCoord = new Coordinate(1, 1);
        unvisitedCells.remove(currentCoord);

        Stack<Coordinate> stack = new Stack<>();

        while (!unvisitedCells.isEmpty()) {
            Coordinate unvisitedNeighbour = getNeighbours(currentCoord, height, width, unvisitedCells);
            if (unvisitedNeighbour != null) {
                stack.push(currentCoord);
                int row = currentCoord.row() + (unvisitedNeighbour.row() - currentCoord.row()) / 2;
                int col = currentCoord.col() + (unvisitedNeighbour.col() - currentCoord.col()) / 2;
                grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);
                currentCoord = unvisitedNeighbour;
                unvisitedCells.remove(currentCoord);
            } else if (!stack.isEmpty()) {
                currentCoord = stack.pop();
            } else {
                currentCoord = unvisitedCells.iterator().next();
                unvisitedCells.remove(currentCoord);
            }
        }

        return new Maze(height, width, grid);
    }

    static Cell[][] createDefaultMaze(int height, int width) {

        Cell[][] grid = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0 || j % 2 == 0) {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                } else {
                    grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
                }
            }
        }

        return grid;
    }

    static Coordinate getNeighbours(Coordinate coordinate, int height, int width, HashSet<Coordinate> unvisited) {

        ArrayList<Coordinate> unvisitedNeighbours = new ArrayList<>();

        for (int i = START_TO_FIND_NEIGHBOUR; i <= 2; i += STEP_TO_FIND_NEIGHBOUR) {
            Solver.checkNeighbours(coordinate, height, width, unvisited, unvisitedNeighbours, i);
        }
        if (unvisitedNeighbours.isEmpty()) {
            return null;
        }
        return unvisitedNeighbours.get(new Random().nextInt(unvisitedNeighbours.size()));

    }

    static HashSet<Coordinate> createUnvisitedCellsSet(int height, int width) {
        HashSet<Coordinate> unvisitedCells = new HashSet<>();
        for (int i = 1; i < height; i += 2) {
            for (int j = 1; j < width; j += 2) {
                unvisitedCells.add(new Coordinate(i, j));
            }
        }
        return unvisitedCells;
    }

    static boolean isValidCoordinate(int row, int col, int height, int width) {
        return 1 <= row && row < height && 1 <= col && col < width;
    }

    static public Maze generateWithPrimaAlgorithm(int givenHeight, int givenWidth) {

        assert givenHeight > 0;
        assert givenWidth > 0;
        int height = givenHeight * 2 + 1;
        int width = givenWidth * 2 + 1;
        Cell[][] grid = createAllWallsGrid(height, width);

        Random rd = new Random();
        int row = rd.nextInt(height / 2) * 2 + 1;
        int col = rd.nextInt(width / 2) * 2 + 1;
        grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);

        ArrayList<Coordinate> cellsToCheck = createCellsToCheck(row, col, height, width);

        while (!cellsToCheck.isEmpty()) {
            int index = rd.nextInt(cellsToCheck.size());
            Coordinate coordinate = cellsToCheck.get(index);
            row = coordinate.row();
            col = coordinate.col();
            grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);
            cellsToCheck.remove(index);

            ArrayList<Integer> directions = new ArrayList<>();

            for (int i = 0; i < ROW_MOVE.length; i++) {
                directions.add(i);
            }

            while (!directions.isEmpty()) {
                int dirIndex = rd.nextInt(directions.size());
                int direction = directions.get(dirIndex);

                if (isValidCoordinate(row + ROW_MOVE[dirIndex] * 2, col + COL_MOVE[dirIndex] * 2, height, width)
                    &&
                    grid[row + ROW_MOVE[dirIndex] * 2][col + COL_MOVE[dirIndex] * 2].type().equals(Cell.Type.PASSAGE)) {
                    int curRow = row + ROW_MOVE[dirIndex];
                    int curCol = col + COL_MOVE[dirIndex];
                    grid[curRow][curCol] = new Cell(curRow, curCol, Cell.Type.PASSAGE);
                    directions.clear();
                    continue;
                }

                directions.remove(dirIndex);

            }

            for (int i = 0; i < ROW_MOVE.length; i++) {
                int curRow = row + ROW_MOVE[i] * 2;
                int curCol = col + COL_MOVE[i] * 2;
                if (isValidCoordinate(curRow, curCol, height, width)
                    && grid[curRow][curCol].type().equals(Cell.Type.WALL)) {
                    cellsToCheck.add(new Coordinate(curRow, curCol));
                }
            }

        }

        return new Maze(height, width, grid);
    }

    static ArrayList<Coordinate> createCellsToCheck(int row, int col, int height, int width) {

        ArrayList<Coordinate> cellsToCheck = new ArrayList<>();
        for (int i = 0; i < ROW_MOVE.length; i++) {
            if (isValidCoordinate(row + ROW_MOVE[i] * 2, col + COL_MOVE[i] * 2, height, width)) {
                cellsToCheck.add(new Coordinate(row + ROW_MOVE[i] * 2, col + COL_MOVE[i] * 2));
            }
        }
        return cellsToCheck;
    }

    static Cell[][] createAllWallsGrid(int height, int width) {
        Cell[][] grid = new Cell[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
        return grid;
    }

}

