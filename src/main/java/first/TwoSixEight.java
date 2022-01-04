package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-03 20:01
 **/
public class TwoSixEight {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int total = length * (length + 1) / 2;
        for (int num : nums) {
            total = total - num;
        }
        return total;
    }
}
