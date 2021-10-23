package first;

import java.util.Map;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-23 16:11
 **/
public class OneFiveTwo {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        System.arraycopy(nums, 0, max, 0, length);
        System.arraycopy(nums, 0, min, 0, length);
        for (int i = 1; i < length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
        }

        int ans = max[0];
        for (int i = 1; i < length; i++) {
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
