package second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/30
 * @description
 */
public class TwoReal {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new String[2 * n], 0);
        return res;
    }

    private void backtrack(List<String> res, String[] temp, int index) {
        if (index == temp.length) {
            if (check(temp)) {
                res.add(String.valueOf(temp));
            }
            return;
        }
        temp[index] = "(";
        backtrack(res, temp, index + 1);
        temp[index] = ")";
        backtrack(res, temp, index + 1);
    }

    private boolean check(String[] temp) {
        int count = 0;
        for (String s : temp) {
            if ("(".equals(s)) {
                count += 1;
            } else {
                count -= 1;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
