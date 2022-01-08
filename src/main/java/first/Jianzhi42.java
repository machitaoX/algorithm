package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-08 16:15
 **/
public class Jianzhi42 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] tempNum = new int[length];
        tempNum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            tempNum[i] = Math.max(tempNum[i - 1] + nums[i], nums[i]);
            max = Math.max(tempNum[i], max);
        }
        return max;
    }
}
