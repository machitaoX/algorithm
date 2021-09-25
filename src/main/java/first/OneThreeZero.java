package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/9/24
 * @description
 */
public class OneThreeZero {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> temp, String s) {
        if ("".equals(s) || s == null) {
            List<String> copy = new ArrayList<>(temp);
            res.add(copy);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!check(s.substring(0, i + 1))) {
                continue;
            }
            temp.add(s.substring(0, i + 1));
            dfs(res, temp, s.substring(i + 1));
            temp.remove(temp.size() - 1);
        }

    }

    private boolean check(String subString) {
        if ("".equals(subString) || subString == null) {
            return false;
        }
        char[] strArray = subString.toCharArray();
        int left = 0, right = subString.length() - 1;
        while (left <= right) {
            if (strArray[left] != strArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
