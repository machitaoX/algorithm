package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-08 18:24
 **/
public class Jianzhi29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int step = rowNum * colNum;
        boolean[][] record = new boolean[rowNum][colNum];
        int[] res = new int[step];
        int[][] route = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int index = 0;
        for (int i = 0; i < step; i++) {
            res[i] = matrix[row][col];
            record[row][col] = true;
            int nextRow = row + route[index][0];
            int nextCol = col + route[index][1];
            if (nextCol < 0 || nextCol >= colNum || nextRow < 0 || nextRow >= rowNum || record[nextRow][nextCol]) {
                index = (index + 1) % 4;
            }
            row = row + route[index][0];
            col = col + route[index][1];
        }
        return res;
    }
}
