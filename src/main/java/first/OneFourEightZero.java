package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-06 20:22
 **/
public class OneFourEightZero {
    public int[] runningSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
        }
        return nums;
    }
}
