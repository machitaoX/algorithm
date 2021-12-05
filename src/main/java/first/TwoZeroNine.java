package first;

/**
 * @author machitao
 * @date 2021/12/5
 * @description
 */
public class TwoZeroNine {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, min = nums.length, sum = nums[0];
        boolean has = false;
        while (start <= end && end < nums.length) {
            if (sum >= target) {
                has = true;
                min = Math.min(end - start + 1, min);
                if (min == 1) {
                    break;
                }
                sum -= nums[start];
                start++;

            } else {
                end++;
                if (end >= nums.length) {
                    break;
                }
                sum += nums[end];
            }
        }
        if (!has) {
            return 0;
        }
        return min;
    }
}
