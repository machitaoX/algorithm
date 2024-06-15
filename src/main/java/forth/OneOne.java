package forth;

/**
 * @program: algorithm
 * @description: 11
 * @author: machitao
 * @create: 2024-06-13 23:26
 **/
public class OneOne {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            int length = right - left;
            max = Math.max(max, length * Math.min(leftValue, rightValue));
            if (leftValue < rightValue) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
