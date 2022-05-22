package first;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-05-21 20:47
 **/
public class ThreeOneThree {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        int length = primes.length;
        int[] pointers = new int[length];
        int[] nums = new int[length];
        Arrays.fill(nums, 1);
        for (int i = 1; i < n + 1; i++) {
            int minNum = Arrays.stream(nums).min().getAsInt();
            dp[i] = minNum;
            for (int j = 0; j < length; j++) {
                if (nums[j] == minNum) {
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return dp[n];
    }
}
