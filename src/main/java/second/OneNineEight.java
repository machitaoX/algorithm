package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-01 16:38
 **/
public class OneNineEight {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] maxArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (length == 1) {
                    return nums[0];
                }
                maxArray[0] = nums[0];
            } else if (i == 1) {
                maxArray[1] = nums[1];
            } else if (i == 2) {
                maxArray[2] = nums[2] + nums[0];
            } else {
                // ||||
                maxArray[i] = Math.max(maxArray[i - 2], maxArray[i - 3]) + nums[i];
            }
        }
        return Math.max(maxArray[length - 1], maxArray[length - 2]);
    }
}
