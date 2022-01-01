package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-30 21:57
 **/
public class FourSix {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempArray = new ArrayList<>();
        for (int i : nums) {
            tempArray.add(i);
        }
        dfs(res, nums.length, tempArray, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, List<Integer> temp, int first) {
        if (first == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(temp, i, first);
            dfs(res, n, temp, first + 1);
            Collections.swap(temp, i, first);
        }
    }
}
