package first;

/**
 * @author machitao
 * @date 2021/11/6
 * @description
 */
public class OneSixSeven {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] res = new int[2];
        while (start < end) {
            int temp = numbers[start] + numbers[end];
            if (temp == target) {
                res[0] = start;
                res[1] = end;
                return res;
            } else if (temp > target) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }
}
