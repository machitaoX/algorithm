package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 10:24
 **/
public class FourOneFive {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (length1 > 0 || length2 > 0) {
            length1--;
            length2--;
            int num1Value = 0;
            int num2Value = 0;
            if (length1 >= 0) {
                num1Value = num1.charAt(length1) - '0';
            }
            if (length2 >= 0) {
                num2Value = num2.charAt(length2) - '0';
            }
            int temp = num1Value + num2Value + add;
            add = temp / 10;
            temp = temp % 10;
            sb.insert(0, temp);
        }
        if (add != 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
