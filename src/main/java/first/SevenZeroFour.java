package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-08 14:25
 **/
public class SevenZeroFour {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int medium = (end + start) / 2;
            if (nums[medium] < target) {
                start = medium;
            } else if (nums[medium] == target) {
                return medium;
            } else {
                end = medium;
            }
            if (end - start == 1) {
                if (nums[start] == target) {
                    return start;
                }
                if (nums[end] == target) {
                    return end;
                }
                return -1;
            }
            if (start == end) {
                return nums[start] == target ? start : -1;
            }
        }
        return -1;
    }
}
