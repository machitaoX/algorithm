package forth;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 16
 * @author: machitao
 * @create: 2024-06-16 22:21
 **/
public class OneSix {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target)
                    while (j < k && nums[k] == nums[--k]);
                else
                    while (j < k && nums[j] == nums[++j]);
            }
        }
        return result;
    }
}
