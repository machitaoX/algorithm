package forth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: 15
 * @author: machitao
 * @create: 2024-06-16 10:27
 **/
public class OneFive {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            if (first + nums[nums.length - 2] + nums[nums.length - 1] < 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int second = nums[j];
                if (first + second + nums[j + 1] > 0) {
                    break;
                }

                int k = nums.length - 1;
                int third = nums[k];
                while (j < k && first + second + third > 0) {
                    k--;
                    third = nums[k];
                }
                if (j == k) {
                    break;
                }
                if (first + second + third == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.add(second);
                    temp.add(third);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
