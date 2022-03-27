package first;

/**
 * @author machitao
 * @date 2022/3/27
 * @description
 */
public class ThreeZeroThree {
    class NumArray {
        int[] res;
        int[] original;

        public NumArray(int[] nums) {
            res = new int[nums.length];
            original = nums;
            res[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res[i] = res[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return res[right] - res[left] + original[left];
        }
    }
}
