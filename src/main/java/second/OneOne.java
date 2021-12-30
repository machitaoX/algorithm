package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 19:41
 **/
public class OneOne {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                max = Math.max(max, (end - start) * height[start]);
                start++;
            } else {
                max = Math.max(max, (end - start) * height[end]);
                end--;
            }
        }
        return max;
    }
}
