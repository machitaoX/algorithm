package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-03 15:05
 **/
public class TwoSixThree {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        int left = 0;
        while (n != 1) {
            left = n % 2;
            if (left != 0) {
                break;
            }
            n = n / 2;
        }
        while (n != 1) {
            left = n % 3;
            if (left != 0) {
                break;
            }
            n = n / 3;
        }
        while (n != 1) {
            left = n % 5;
            if (left != 0) {
                break;
            }
            n = n / 5;
        }
        return n == 1;
    }
}
