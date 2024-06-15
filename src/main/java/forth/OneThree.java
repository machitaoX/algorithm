package forth;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 13
 * @author: machitao
 * @create: 2024-06-15 23:36
 **/
public class OneThree {
    public int romanToInt(String s) {
        int result = 0;
        while (!"".equals(s)) {
            if (s.startsWith("M")) {
                result = result + 1000;
                s = s.substring(1);
            } else if (s.startsWith("CM")) {
                result = result + 900;
                s = s.substring(2);
            } else if (s.startsWith("D")) {
                result = result + 500;
                s = s.substring(1);
            } else if (s.startsWith("CD")) {
                result = result + 400;
                s = s.substring(2);
            } else if (s.startsWith("C")) {
                result = result + 100;
                s = s.substring(1);
            } else if (s.startsWith("XC")) {
                result = result + 90;
                s = s.substring(2);
            } else if (s.startsWith("L")) {
                result = result + 50;
                s = s.substring(1);
            } else if (s.startsWith("XL")) {
                result = result + 40;
                s = s.substring(2);
            } else if (s.startsWith("X")) {
                result = result + 10;
                s = s.substring(1);
            } else if (s.startsWith("IX")) {
                result = result + 9;
                s = s.substring(2);
            } else if (s.startsWith("V")) {
                result = result + 5;
                s = s.substring(1);
            } else if (s.startsWith("IV")) {
                result = result + 4;
                s = s.substring(2);
            } else {
                result = result + 1;
                s = s.substring(1);
            }
        }
        return result;
    }
}
