package first;

/**
 * @author machitao
 * @date 2022/2/25
 * @description
 */
public class TwoEightSeven {
    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 < i) {
                return nums[i];
            } else if (nums[i] - 1 > i) {
                while (nums[i] - 1 > i) {
                    int temp = nums[i] - 1;
                    if (nums[temp] == nums[i]) {
                        return nums[i];
                    }
                    nums[i] = nums[temp];
                    nums[temp] = temp + 1;
                }
                if (nums[i] - 1 < i) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2,1,2}));
    }
}
