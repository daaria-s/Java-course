package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    private static final int BOARD_SIZE = 8;
    private static final int KNIGHT_STEP = 3;

    private static boolean validCoords(int row, int col) {
        return 0 <= row && row < BOARD_SIZE && 0 <= col && col < BOARD_SIZE;
    }

    private static boolean canCapture(int[][] board, int row, int col) {
        int vRow = 0;
        int vCol = -1;
        for (vRow = -1; vRow < 2; vRow += 2) {
            for (int coef = 1; coef < KNIGHT_STEP; coef++) {
                int newRow = row + vRow * coef;
                int newCol = col + vCol * (KNIGHT_STEP - coef);
                if (validCoords(newRow, newCol) && board[newRow][newCol] == 1) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == 1 && canCapture(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
