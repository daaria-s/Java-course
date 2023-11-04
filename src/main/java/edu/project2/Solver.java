package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Generator.isValidCoordinate;

public class Solver {

    private Solver() {
    }

    static public ArrayList<Coordinate> solveWithBfs(Maze maze, Coordinate start, Coordinate end) {

        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        Coordinate[][] comeFrom = new Coordinate[maze.getHeight()][maze.getWidth()];

        for (boolean[] line : visited) {
            Arrays.fill(line, false);
        }

        visited[start.row()][start.col()] = true;

        ArrayDeque<Coordinate> queue = new ArrayDeque<>();

        queue.addLast(start);

        int[] rowMove = {-1, 1, 0, 0};
        int[] colMove = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Coordinate currentCell = queue.pop();
            for (int i = 0; i < rowMove.length; i++) {
                int newRow = currentCell.row() + rowMove[i];
                int newCol = currentCell.col() + colMove[i];
                if (!visited[newRow][newCol] && maze.getCellType(newRow, newCol) == Cell.Type.PASSAGE) {
                    comeFrom[newRow][newCol] = currentCell;
                    visited[newRow][newCol] = true;
                    queue.addLast(new Coordinate(newRow, newCol));
                }
            }
            if (visited[end.row()][end.col()]) {
                break;
            }
        }

        ArrayList<Coordinate> answer = new ArrayList<>();

        if (!visited[end.row()][end.col()]) {
            return answer;
        }

        Coordinate currentCoord = end;

        while (currentCoord != start) {
            answer.add(currentCoord);
            currentCoord = comeFrom[currentCoord.row()][currentCoord.col()];
        }
        answer.add(currentCoord);

        Collections.reverse(answer);

        return answer;
    }

    static public ArrayList<Coordinate> solveWithBackTracking(Maze maze, Coordinate start, Coordinate end) {

        HashSet<Coordinate> unvisitedCells = new HashSet<>();

        for (int i = 1; i < maze.getHeight(); i++) {
            for (int j = 1; j < maze.getWidth(); j++) {
                if (maze.getCellType(i, j) == Cell.Type.PASSAGE) {
                    unvisitedCells.add(new Coordinate(i, j));
                }
            }
        }

        Coordinate currentCoord = start;
        unvisitedCells.remove(currentCoord);

        Stack<Coordinate> stack = new Stack<>();

        while (true) {
            Coordinate unvisitedNeighbour =
                getNeighbours(currentCoord, maze.getHeight(), maze.getWidth(), unvisitedCells);
            if (unvisitedNeighbour != null) {
                stack.push(currentCoord);

                if (unvisitedNeighbour.equals(end)) {
                    stack.push(unvisitedNeighbour);
                    break;
                }
                currentCoord = unvisitedNeighbour;
                unvisitedCells.remove(currentCoord);

            } else if (!stack.isEmpty()) {
                currentCoord = stack.pop();
            } else {
                return new ArrayList<>();
            }
        }

        ArrayList<Coordinate> answer = new ArrayList<>(stack);
        return answer;

    }

    static Coordinate getNeighbours(Coordinate coordinate, int height, int width, HashSet<Coordinate> unvisited) {
        ArrayList<Coordinate> unvisitedNeighbours = new ArrayList<>();
        for (int i = -1; i <= 1; i += 2) {
            checkNeighbours(coordinate, height, width, unvisited, unvisitedNeighbours, i);
        }

        if (unvisitedNeighbours.isEmpty()) {
            return null;
        }
        return unvisitedNeighbours.get(new Random().nextInt(unvisitedNeighbours.size()));

    }

    static void checkNeighbours(
        Coordinate coordinate,
        int height,
        int width,
        HashSet<Coordinate> unvisited,
        ArrayList<Coordinate> unvisitedNeighbours,
        int i
    ) {
        if (isValidCoordinate(coordinate.row(), coordinate.col() + i, height, width)) {
            Coordinate currentCoord = new Coordinate(coordinate.row(), coordinate.col() + i);
            if (unvisited.contains(currentCoord)) {
                unvisitedNeighbours.add(currentCoord);
            }
        }
        if (isValidCoordinate(coordinate.row() + i, coordinate.col(), height, width)) {
            Coordinate currentCoord = new Coordinate(coordinate.row() + i, coordinate.col());
            if (unvisited.contains(currentCoord)) {
                unvisitedNeighbours.add(currentCoord);
            }
        }
    }
}
