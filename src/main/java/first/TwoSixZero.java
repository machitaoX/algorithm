package first;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-03 11:20
 **/
public class TwoSixZero {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int[] res = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i+1]) {
                    res = new int[2];
                    res[0] = nums[i];
                }
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) {
                    res[1] = nums[i];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    if (res == null) {
                        res = new int[2];
                        res[0] = nums[i];
                        continue;
                    }
                    res[1] = nums[i];
                }
            }
        }
        return res;
    }
}
