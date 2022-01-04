package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-03 10:55
 **/
public class TwoFiveEight {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num > 0) {
                temp = temp + (num % 10);
                num = num / 10;
            }
            num = temp;
        }
        return num;
    }
}
