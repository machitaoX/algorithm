package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-13 21:59
 **/
public class TwoTwoOne {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length - i <= max) {
                return max * max;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                int diff = Math.min(matrix.length - i, matrix[0].length - j);
                for (int k = 0; k < diff; k++) {
                    if (check(j, i, j + k, i + k, matrix)) {
                        max = Math.max(max, k + 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return max * max;
    }
    private boolean check(int startX, int startY, int endX, int endY, char[][] matrix) {
        if (startX >= matrix[0].length
                || endX >= matrix[0].length
                || startY >= matrix.length
                || endY >= matrix.length) {
            return false;
        }
        for (int i = startY; i <= endY; i++) {
            if (matrix[i][endX] != '1') {
                return false;
            }
        }
        for (int i = startX; i <= endX; i++) {
            if (matrix[endY][i] != '1') {
                return false;
            }
        }
        return true;
    }
}
