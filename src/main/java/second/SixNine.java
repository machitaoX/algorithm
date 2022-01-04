package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-01 17:23
 **/
public class SixNine {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = 1 + (r - 1) / 2;
            if ((long)mid * mid < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
