package second;

/**
 * @author machitao
 * @date 2021/12/31
 * @description
 */
public class FiveFive {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightMax = 0;
        for (int i = 0; i < length; i++) {
            if (rightMax >= i) {
                rightMax = Math.max(rightMax, i + nums[i]);
                if (rightMax >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
