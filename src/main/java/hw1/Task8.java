package hw1;

public final class Task8 {
    private Task8() {
    }


    private static boolean validCoords(int row, int col) {
        return 0 <= row && row < 8 && 0 <= col && col < 8;
    }

    private static boolean canCapture(int[][] board, int row, int col) {
        int vRow = 0;
        int vCol = -1;
        for (vRow = -1; vRow < 2; vRow += 2) {
            for (int coef = 1; coef < 3; coef++) {
                int newRow = row + vRow * coef;
                int newCol = col + vCol * (3 - coef);
                if (validCoords(newRow, newCol) && board[newRow][newCol] == 1) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == 1 && canCapture(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
