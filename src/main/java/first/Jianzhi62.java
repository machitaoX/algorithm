package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 14:40
 **/
public class Jianzhi62 {
    public int lastRemaining(int n, int m) {
        return move(n, m);
    }

    private int move(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = move(n - 1, m);
        return (m + x) % n;
    }
}
