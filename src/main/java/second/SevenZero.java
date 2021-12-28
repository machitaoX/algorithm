package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-28 16:47
 **/
public class SevenZero {
    public int climbStairs(int n) {
        int[] step = new int[n];
        step[0] = 1;
        if (n > 1) {
            step[1] = 2;
        }
        for (int i = 2; i < n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n - 1];
    }
}
