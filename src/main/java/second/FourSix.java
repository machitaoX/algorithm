package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/31
 * @description
 */
public class FourSix {
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        visit = new boolean[length];
        Arrays.sort(nums);
        backtrack(nums, res, length, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, int length, List<Integer> temp) {
        if (temp.size() == length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (visit[i] || i != 0 && nums[i] == nums[i - 1] && !visit[i - 1]) {
                continue;
            }
            visit[i] = true;
            temp.add(nums[i]);
            backtrack(nums, res, length, temp);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }
}
