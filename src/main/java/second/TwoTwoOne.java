package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 09:20
 **/
public class TwoTwoOne {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            int rowDiff = row - i - 1;
            if (rowDiff < max) {
                return max * max;
            }
            for (int j = 0; j < col; j++) {
                int colDiff = col - j - 1;
                if (colDiff < max) {
                    break;
                }
                if (matrix[i][j] == '1') {
                    int diff = Math.min(rowDiff, colDiff);
                    max = Math.max(check(i, j, i + diff, j + diff, matrix), max);
                }
            }
        }
        return max * max;
    }
    private int check(int startRow, int startCol, int endRow, int endCol, char[][] matrix) {
        int max = 1;
        // 横向
        int diff = endRow - startRow;
        for (int i = 1; i <= diff; i++) {
            int newRow = startRow + i;
            for (int newCol = startCol; newCol <= startCol + i; newCol++) {
                if (matrix[newRow][newCol] != '1'){
                    return max;
                }
            }
            int newCol = startCol + i;
            newRow = startRow;
            for (; newRow <= startRow + i; newRow++) {
                if (matrix[newRow][newCol] != '1'){
                    return max;
                }
            }
            max++;
        }
        return max;
    }
}
