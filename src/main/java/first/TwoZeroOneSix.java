package first;

/**
 * @author machitao
 * @date 2022/2/26
 * @description
 */
public class TwoZeroOneSix {
    public static int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, perMin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > perMin) {
                ans = Math.max(nums[i] - perMin, ans);
            } else {
                perMin = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{1,5,2,10}));
    }
}
