package first;

/**
 * @author machitao
 * @date 2022/3/27
 * @description
 */
public class ThreeZeroFour {
    class NumMatrix {
        int[][] matrix;
        int[][] calculate;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            calculate = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int up = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    int left = 0;
                    int dup = 0;
                    if (i != 0) {
                        up = calculate[i-1][j];
                    }
                    if (j != 0) {
                        left = calculate[i][j - 1];
                    }
                    if (i != 0 && j != 0) {
                        dup = calculate[i - 1][j - 1];
                    }
                    calculate[i][j] = matrix[i][j] + up + left - dup;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int first = 0;
            int second = 0;
            int third = 0;
            if (col1 != 0) {
                first = calculate[row2][col1 - 1];
            }
            if (row1 != 0) {
                second = calculate[row1 - 1][col2];
            }
            if (col1 != 0 && row1 != 0) {
                third = calculate[row1 - 1][col1 - 1];
            }
            return calculate[row2][col2] - first - second + third;
        }
    }
}
