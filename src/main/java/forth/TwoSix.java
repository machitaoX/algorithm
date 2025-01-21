package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2025-01-22 00:04
 **/
public class TwoSix {
    public int removeDuplicates(int[] nums) {
        int index = 0, pre = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (pre != cur) {
                nums[index] = cur;
                index++;
                result++;
                pre = cur;
            }
        }
        return result;
    }
}
