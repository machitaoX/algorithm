package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-08-27 23:05
 **/
public class Seven {
    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            //判断整数溢出
            if (last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
