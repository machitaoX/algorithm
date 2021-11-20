package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-19 22:53
 **/
public class OneEightNine {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
