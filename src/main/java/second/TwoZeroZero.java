package second;

import java.util.Arrays;

/**
 * @author machitao
 * @date 2021/12/29
 * @description
 */
public class TwoZeroZero {
    int res = 0;
    public int numIslands(char[][] grid) {

        int row = grid.length, col = grid[0].length;
        int[][] route = new int[row][col];
        for (int[] array : route) {
            Arrays.fill(array, 0);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (route[i][j] == 0) {
                    route[i][j] = 1;
                    if (grid[i][j] == '1') {
                        res++;
                        find(grid, route,i + 1, j, row, col);
                        find(grid, route,i - 1, j, row, col);
                        find(grid, route, i, j + 1, row, col);
                        find(grid, route,i, j - 1, row, col);
                    }
                }
            }
        }
        return res;
    }

    private void find(char[][] grid, int[][] route, int i, int j, int rowCount, int colCount) {
        if (i < 0 || i >= rowCount
                || j < 0 || j >= colCount) {
            return;
        }
        if (route[i][j] == 0) {
            route[i][j] = 1;
            if (grid[i][j] == '1') {
                find(grid, route,i + 1, j, rowCount, colCount);
                find(grid, route,i - 1, j, rowCount, colCount);
                find(grid, route, i, j + 1, rowCount, colCount);
                find(grid, route,i, j - 1, rowCount, colCount);
            }
        }
    }
}
