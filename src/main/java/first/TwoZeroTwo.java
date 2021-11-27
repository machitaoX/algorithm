package first;

import java.util.HashSet;

/**
 * @author machitao
 * @date 2021/11/27
 * @description
 */
public class TwoZeroTwo {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 0) {
            if (n == 1) {
                return true;
            }
            n = calculate(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);

        }
        return false;
    }



    private int calculate(int n) {
        int temp = n;
        int res = 0;
        while (temp != 0) {
            int d = temp % 10;
            temp = temp / 10;
            res += d * d;
        }
        return res;
    }
}
