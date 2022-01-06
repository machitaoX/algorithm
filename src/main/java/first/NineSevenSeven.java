package first;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-06 20:41
 **/
public class NineSevenSeven {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
