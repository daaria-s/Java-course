package edu.project2;

import java.util.ArrayList;
import java.util.Scanner;
import static edu.project2.Generator.generateWithDfs;
import static edu.project2.Generator.generateWithPrimaAlgorithm;
import static edu.project2.Renderer.render;
import static edu.project2.Solver.solveWithBackTracking;
import static edu.project2.Solver.solveWithBfs;

@SuppressWarnings("RegexpSinglelineJava")
class Main {

    static final int MAZE_SIZE = 9;
    static final int LOWER_RIGHT_COORD = MAZE_SIZE * 2 - 1;

    private Main() {
    }

    static void printStarting() {
        System.out.println("Welcome to maze generation!");
    }

    static void printGenerationStart() {
        System.out.println(
            "Print 0, if you want to generate maze with dfs algorithm "
                + "or 1, if you want to generate maze with Prima algorithm");
        System.out.println("Print -1 to quit");
    }

    static void printSolvingStart() {
        System.out.println(
            "Print 0, if you want to solve maze with bfs or 1, if you want to solve maze with dfs algorithm");
    }

    static void printIncorrectInput() {
        System.out.println("Input is incorrect");
    }

    static void printNotSolved() {
        System.out.println("Can't solve the maze");
    }

    static void printTryToFind() {
        System.out.println("Trying to find the solution from upper left corner to lower right corner...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze;
        int rows = MAZE_SIZE;
        int cols = MAZE_SIZE;
        printStarting();
        while (true) {
            printGenerationStart();
            String userInput = scanner.nextLine();
            if (userInput.equals("-1")) {
                break;
            }
            if (userInput.equals("0")) {
                maze = generateWithDfs(rows, cols);
            } else if (userInput.equals("1")) {
                maze = generateWithPrimaAlgorithm(rows, cols);
            } else {
                printIncorrectInput();
                continue;
            }
            System.out.println(render(maze));
            printSolvingStart();
            String solveAlgorithm = scanner.nextLine();

            if (solveAlgorithm.equals("-1")) {
                break;
            }
            while (!solveAlgorithm.equals("0") && !solveAlgorithm.equals("1")) {
                printIncorrectInput();
                solveAlgorithm = scanner.nextLine();
            }
            ArrayList<Coordinate> solution;
            printTryToFind();
            if (solveAlgorithm.equals("0")) {
                solution =
                    solveWithBfs(maze, new Coordinate(1, 1), new Coordinate(LOWER_RIGHT_COORD, LOWER_RIGHT_COORD));
            } else {
                solution = solveWithBackTracking(maze,
                    new Coordinate(1, 1),
                    new Coordinate(LOWER_RIGHT_COORD, LOWER_RIGHT_COORD)
                );
            }
            if (solution.isEmpty()) {
                printNotSolved();
                continue;
            }
            System.out.println(render(maze, solution));
        }

    }

}
