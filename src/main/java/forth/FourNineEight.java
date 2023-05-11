package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-05-10 00:21
 **/
public class FourNineEight {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int length = n * m;
        int[] res = new int[length];
        int step = m + n - 1;
        int pos = 0;
        for (int i = 0; i < step; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    y++;
                    x--;
                }
            }
        }
        return res;
    }
}
