package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;

public class Renderer {

    private Renderer() {
    }

    static final String PASSAGE_SYMBOL = "⬜\uFE0F";
    static final String WALL_SYMBOL = "⬛\uFE0F";

    static final String PATH_SYMBOL = "\uD83D\uDFE5";

    @SuppressWarnings("MultipleStringLiterals")
    static final String START_SYMBOL = "\uD83D\uDEA9";

    static final String FINISH_SYMBOL = "\uD83D\uDEA9";

    static public String render(Maze maze) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getCellType(i, j).equals(Cell.Type.WALL)) {
                    result.append(WALL_SYMBOL);
                } else {
                    result.append(PASSAGE_SYMBOL);
                }
            }
            result.append('\n');
        }
        return result.toString();
    }

    static public String render(Maze maze, ArrayList<Coordinate> path) {

        assert !path.isEmpty();

        Coordinate start = path.getFirst();
        Coordinate finish = path.getLast();

        HashSet<Coordinate> myPath = new HashSet<>(path);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {

                Coordinate curCoord = new Coordinate(i, j);
                if (curCoord.equals(start)) {
                    result.append(START_SYMBOL);
                } else if (curCoord.equals(finish)) {
                    result.append(FINISH_SYMBOL);
                } else if (myPath.contains(curCoord)) {
                    result.append(PATH_SYMBOL);
                } else if (maze.getCellType(i, j).equals(Cell.Type.WALL)) {
                    result.append(WALL_SYMBOL);
                } else {
                    result.append(PASSAGE_SYMBOL);
                }
            }
            result.append('\n');
        }
        return result.toString();

    }
}
