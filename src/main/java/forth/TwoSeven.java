package forth;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2025-01-22 23:33
 **/
public class TwoSeven {
    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] params = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int i = TwoSeven.removeElement(params, 2);
        System.out.println("i = " + i);
        System.out.println("params = " + Arrays.toString(params));
    }
}
