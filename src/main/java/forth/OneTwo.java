package forth;

/**
 * @program: algorithm
 * @description: 12
 * @author: machitao
 * @create: 2024-06-15 20:30
 **/
public class OneTwo {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        if (num >= 1000) {
            int thousandCount = num / 1000;
            num = num % 1000;
            for (int i = 0; i < thousandCount; i++) {
                result.append("M");
            }
        }
        if (num >= 900) {
            result.append("CM");
            num = num - 900;
        }
        if (num >= 500) {
            num = num - 500;
            result.append("D");
        }
        if (num >= 400) {
            num = num - 400;
            result.append("CD");
        }

        if (num >= 100) {
            int thunCount = num / 100;
            num = num % 100;
            for (int i = 0; i < thunCount; i++) {
                result.append("C");
            }
        }
        if (num >= 90) {
            result.append("XC");
            num = num - 90;
        }
        if (num >= 50) {
            num = num - 50;
            result.append("L");
        }
        if (num >= 40) {
            num = num - 40;
            result.append("XL");
        }

        if (num >= 10) {
            int singleCount = num / 10;
            num = num % 10;
            for (int i = 0; i < singleCount; i++) {
                result.append("X");
            }
        }
        if (num >= 9) {
            result.append("IX");
            num = num - 9;
        }
        if (num >= 5) {
            num = num - 5;
            result.append("V");
        }
        if (num >= 4) {
            num = num - 4;
            result.append("IV");
        }

        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                result.append("I");
            }
        }
        return result.toString();
    }
}
