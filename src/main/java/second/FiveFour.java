package second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/30
 * @description
 */
public class FiveFour {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int total = row * col;
        int[][] direct = new int[][]{{0, 1},  {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        int rowMove = 0, colMove = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < total; i++) {
            res.add(matrix[rowMove][colMove]);
            visited[rowMove][colMove] = true;
            int nextRow = rowMove + direct[directIndex][0], nextCol = colMove + direct[directIndex][1];
            if (nextCol < 0 || nextCol >= col || nextRow < 0 || nextRow >= row || visited[nextRow][nextCol]) {
                directIndex = (directIndex + 1) % 4;
            }
            rowMove = rowMove + direct[directIndex][0];
            colMove = colMove + direct[directIndex][1];
        }
        return res;
    }
}
