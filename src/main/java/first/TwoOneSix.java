package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/12
 * @description
 */
public class TwoOneSix {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return res;
    }

    private void dfs(int cur, int length, int k, int n) {
        if (temp.size() + (length - cur + 1) < k || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == n) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        temp.add(cur);
        dfs(cur + 1, length, k, n);
        temp.remove(temp.size() - 1);
        dfs(cur + 1,length, k, n);
    }
}
