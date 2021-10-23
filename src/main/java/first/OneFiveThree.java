package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-23 16:49
 **/
public class OneFiveThree {
    public int findMin(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    private int dfs(int start, int end, int[] nums) {
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        int medium = (end + start) / 2;
        if (nums[start] > nums[medium]) {
            return dfs(start, medium, nums);
        }
        if (nums[medium + 1] > nums[end]) {
            return dfs(medium + 1, end, nums);
        }
        return Math.min(nums[medium + 1], nums[start]);
    }
}
