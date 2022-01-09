package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 20:25
 **/
public class Jianzhi21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (true) {
            while (left < nums.length && nums[left] % 2 != 0) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
