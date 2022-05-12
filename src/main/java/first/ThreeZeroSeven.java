package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-04-05 20:09
 **/
public class ThreeZeroSeven {
    class NumArray {
        int[] cal;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            cal = new int[nums.length];
            cal[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                cal[i] = cal[i - 1] + nums[i];
            }
        }

        public void update(int index, int val) {
            int before = nums[index];
            int diff = val - before;
            for (int i = index; i < nums.length; i++) {
                cal[i] = cal[i] + diff;
            }
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return cal[right] - cal[left] + nums[left];
        }
    }
}
