package second;

/**
 * @author machitao
 * @date 2021/12/30
 * @description
 */
public class FiveThree {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int i : nums) {
            if (sum < 0) {
                sum = i;
            } else {
                sum = sum + i;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
