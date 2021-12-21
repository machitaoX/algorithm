package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-21 17:21
 **/
public class TwoThreeOne {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
