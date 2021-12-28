package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-26 13:14
 **/
public class TwoFourOne {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int length = expression.length();
        int start = 0;
        for (; start < length; start++) {
            char c = expression.charAt(start);
            if (!Character.isDigit(c)) {
                break;
            }
        }
        if (start == length) {
            res.add(Integer.parseInt(expression));
        }
        for (int i = start; i < length; i++) {
            if (Character.isDigit(expression.charAt(i))) {
                continue;
            }
            char op = expression.charAt(i);
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1, length));
            for (Integer l : left) {
                for (Integer r : right) {
                    if (op == '-') {
                        res.add(l-r);
                    } else if (op == '+') {
                        res.add(l + r);
                    } else {
                        res.add(l * r);
                    }
                }
            }
        }
        return res;
    }
}
