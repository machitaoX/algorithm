package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-23 10:21
 **/
public class TwoThreeEight {
    public int[] productExceptSelf(int[] nums) {
        int s = nums.length;
        int[] res = new int[s];
        int[] left = new int[s];
        left[0] = 1;
        int[] right = new int[s];
        right[s - 1] = 1;
        for (int i = s - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 1; i < s; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < s; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
