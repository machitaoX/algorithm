package second;

import java.util.Collections;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 13:02
 **/
public class ThreeOne {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        int start = length - 2;
        int end = length - 1;
        for (;;) {
            if (nums[start] < nums[start + 1]) {
                int index = findIndex(nums, start + 1, nums[start]);
                swap(nums, start, index);
                reverse(nums, start + 1, end);
                break;
            }
            if (start == 0) {
                reverse(nums, start, end);
                break;
            }
            start--;
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private int findIndex(int[] nums, int endIndex, int target) {
        for (int i = nums.length - 1; i >= endIndex; i--) {
            if (nums[i] > target) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[secondIndex];
        nums[secondIndex] = nums[firstIndex];
        nums[firstIndex] = temp;
    }
}
