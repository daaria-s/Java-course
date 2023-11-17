package edu.project2;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.grid = grid;
    }

    Cell.Type getCellType(int i, int j) {
        return grid[i][j].type();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
