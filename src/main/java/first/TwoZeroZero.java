package first;

import java.util.Arrays;

/**
 * @author machitao
 * @date 2021/11/26
 * @description
 */
public class TwoZeroZero {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] route = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(route[i], 0);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (route[i][j] == 0) {
                    route[i][j] = 1;
                    if (grid[i][j] == '1') {
                        res++;
                        findAndMark(i + 1, j, grid, n, m, route);
                        findAndMark(i - 1, j, grid, n, m, route);
                        findAndMark(i, j + 1, grid, n, m, route);
                        findAndMark(i, j - 1, grid, n, m, route);
                    }
                }
            }
        }
        return res;
    }

    private void findAndMark(int i, int j, char[][] grid, int n, int m, int[][] route) {
        if (i >= n || i < 0 || j >= m || j < 0) {
            return;
        }
        if (route[i][j] == 1) {
            return;
        }
        if (grid[i][j] == '0') {
            route[i][j] = 1;
            return;
        }
        route[i][j] = 1;
        findAndMark(i + 1, j, grid, n, m, route);
        findAndMark(i - 1, j, grid, n, m, route);
        findAndMark(i, j + 1, grid, n, m, route);
        findAndMark(i, j - 1, grid, n, m, route);
    }
}
