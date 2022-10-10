package third;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author
 * @date 2022/9/18
 * @description
 */
public class One {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer needKey = map.get(diff);
            if (needKey != null) {
                return new int[]{i, needKey};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
