package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/28
 * @description
 */
public class FourSix {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        int length = nums.length;
        for (int num : nums) {
            out.add(num);
        }
        backtrack(length, out, res, 0);
        return res;
    }
    private void backtrack(int length, List<Integer> out, List<List<Integer>> res, int start) {
        if (start == length) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = start; i < length; i++) {
            Collections.swap(out, start, i);
            backtrack(length, out, res, start + 1);
            Collections.swap(out, start, i);
        }
    }
}
