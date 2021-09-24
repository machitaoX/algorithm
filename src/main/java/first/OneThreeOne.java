package first;

import java.util.Arrays;

/**
 * @author machitao
 * @date 2021/9/24
 * @description
 */
public class OneThreeOne {

    public static void main(String[] args) {
        char[][] board = {{'X','X'}};

    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] boardMark = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(boardMark[i],0);
        }
        int row = 0;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'O' && boardMark[row][i] != 1) {
                find(board, boardMark, row, i);
            }
        }

        row = m - 1;
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'O' && boardMark[row][i] != 1) {
                find(board, boardMark, row, i);
            }
        }

        int col = 0;
        for (int i = 1; i < m - 1; i++) {
            if (board[i][col] == 'O' && boardMark[i][col] != 1) {
                find(board, boardMark, i, col);
            }
        }

        col = n - 1;
        for (int i = 1; i < m - 1; i++) {
            if (board[i][col] == 'O' && boardMark[i][col] != 1) {
                find(board, boardMark, i, col);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (boardMark[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void find(char[][] board, int[][] boardMark, int i, int j) {
        if (i >= board.length || j >= board[0].length
                || i < 0 || j < 0
                || board[i][j] == 'X' ) {
            return;
        }
        if (board[i][j] == 1) {
            return;
        }
        boardMark[i][j] = 1;
        find(board, boardMark, i + 1, j);
        find(board, boardMark, i - 1, j);
        find(board, boardMark, i, j + 1);
        find(board, boardMark, i, j - 1);
    }
}
