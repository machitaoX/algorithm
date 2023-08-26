package forth;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-08-26 17:46
 **/
public class One {
    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{i, numMap.get(target - nums[i])};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
