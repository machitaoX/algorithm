package first;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-10 22:34
 **/
public class OneSevenFour {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n-1][m] = 1;
        dp[n][m-1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dungeon[j][i] < Math.min(dp[j][i+1], dp[j+1][i])) {
                    dp[j][i] = Math.min(dp[j][i+1], dp[j+1][i]) - dungeon[j][i];
                } else {
                    dp[j][i] = 1;
                }
            }
        }
        return dp[0][0];
    }
}
