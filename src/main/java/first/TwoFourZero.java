package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-26 12:26
 **/
public class TwoFourZero {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0, y = row - 1;
        while (x < col && y >= 0) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
