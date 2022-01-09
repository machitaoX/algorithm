package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 17:03
 **/
public class Jianzhi10 {
    public int numWays(int n) {
        int left2 = 1, left1 = 2;
        if (n == 1 || n == 0) {
            return left2;
        }
        if (n == 2) {
            return left1;
        }
        int now = 0;
        for (int i = 2; i < n; i++) {
            now = (left1 + left2) % 1000000007;
            left2 = left1;
            left1 = now;
        }
        return now % 1000000007;
    }
}
