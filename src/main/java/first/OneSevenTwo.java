package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-08 22:04
 **/
public class OneSevenTwo {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                int k = i;
                while (k % 5 == 0) {
                    ++res;
                    k = k / 5;
                }
            }
        }
        return res;
    }
}
