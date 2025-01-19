package forth;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 22
 * @author: machitao
 * @create: 2025-01-19 21:22
 **/
public class TwoTwo {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen(result, "", 0, 0, n);
        return result;
    }

    private void gen(List<String> result, String temp, Integer leftNumber, Integer rightNumber, Integer n) {
        if (leftNumber == n) {
            if (rightNumber == n) {
                result.add(temp);
            } else {
                gen(result, temp + ")", leftNumber, rightNumber + 1, n);
            }
        } else {
            if (leftNumber == rightNumber) {
                gen(result, temp + "(", leftNumber + 1, rightNumber, n);
            } else {
                gen(result, temp + "(", leftNumber + 1, rightNumber, n);
                gen(result, temp + ")", leftNumber, rightNumber + 1, n);
            }
        }
    }
}
