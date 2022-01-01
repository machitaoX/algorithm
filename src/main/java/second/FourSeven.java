package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/31
 * @description
 */
public class FourSeven {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        backtrack(res, temp, 0, length);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int first, int length) {
        if (first == length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = first; i < length; i++) {
            Collections.swap(temp, first, i);
            backtrack(res, temp, first + 1, length);
            Collections.swap(temp, first, i);
        }
    }
}
