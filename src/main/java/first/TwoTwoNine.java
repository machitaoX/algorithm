package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-19 15:45
 **/
public class TwoTwoNine {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int key = nums[i];
            int sum = 1;
            while (i + 1 < length && nums[i+1] == key) {
                sum++;
                i++;
            }
            if (sum > length / 3) {
                res.add(sum);
            }
        }
        return res;
    }
}
