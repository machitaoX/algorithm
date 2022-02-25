package first;

import java.util.Arrays;

/**
 * @author machitao
 * @date 2022/2/25
 * @description
 */
public class TwoEightNine {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = check(newBoard, i, j, m, n) ? 1 : 0;
            }
        }
    }

    private boolean check(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        if (i + 1 < m) {
            if (board[i + 1][j] == 1) {
                count++;
            }
        }
        if (i + 1 < m && j + 1 < n) {
            if (board[i + 1][j + 1] == 1) {
                count++;
            }
        }
        if (j + 1 < n) {
            if (board[i][j + 1] == 1) {
                count++;
            }
        }
        if (i - 1 >= 0 && j + 1 < n) {
            if (board[i - 1][j + 1] == 1) {
                count++;
            }
        }
        if (i - 1 >= 0) {
            if (board[i - 1][j] == 1) {
                count++;
            }
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (board[i - 1][j - 1] == 1) {
                count++;
            }
        }
        if (j - 1 >= 0) {
            if (board[i][j - 1] == 1) {
                count++;
            }
        }
        if (i + 1 < m && j - 1 >= 0) {
            if (board[i + 1][j - 1] == 1) {
                count++;
            }
        }
        if (board[i][j] == 1) {
            return count == 2 || count == 3;
        }
        return count == 3;
    }
}
