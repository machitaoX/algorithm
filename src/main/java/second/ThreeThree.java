package second;

/**
 * @author machitao
 * @date 2021/12/30
 * @description
 */
public class ThreeThree {
    private Integer index;
    public int search(int[] nums, int target) {
        index = -1;
        check(nums, target, 0, nums.length - 1);
        return index;
    }

    private void check(int[] nums, int target, int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            if (target == nums[start]) {
                index = start;
            }
            return;
        }
        int medium = (start + end) / 2;
        if (nums[medium] == target) {
            index = medium;
            return;
        }
        if (nums[start] > nums[end]) {
            if (nums[medium] >= nums[start]) {
                if (target >= nums[medium] || target <= nums[end]) {
                    check(nums, target, medium + 1, end);
                } else {
                    check(nums, target, start, medium - 1);
                }
            } else {
                if (target >= nums[start] || target <= nums[medium]) {
                    check(nums, target, start, medium - 1);
                } else {
                    check(nums, target, medium + 1, end);
                }
            }
        } else {
            if (target > nums[medium]) {
                check(nums, target, medium + 1, end);
            } else {
                check(nums, target, start, medium - 1);
            }
        }
    }
}
