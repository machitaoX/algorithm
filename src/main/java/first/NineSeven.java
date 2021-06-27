package first;

/**
 * @author machitao
 * @date 2021/6/26
 * @description
 */
public class NineSeven {
    /**
     * 交错字符串
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        return dfs(s1,s2,s3,0,0,0);
    }

    /**
     * 方法一：深度优先遍历，竟然会超时
     * @param s1
     * @param s2
     * @param s3
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    private boolean dfs(String s1, String s2, String s3, int p1, int p2, int p3){
        if (p3 == s3.length()){
            return true;
        }
        char char3 = s3.charAt(p3);
        // p1没超 p2超出
        if (p1 < s1.length() && p2 == s2.length()){
            char char1 = s1.charAt(p1);
            if (char1 == char3){
                return dfs(s1,s2,s3,p1+1,p2,p3+1);
            } else {
                return false;
            }
            // p1超出 p2没超
        } else if (p1 == s1.length() && p2 < s2.length()){
            char char2 = s2.charAt(p2);
            if (char2 == char3){
                return dfs(s1,s2,s3,p1,p2+1,p3+1);
            } else {
                return false;
            }
            // 都没超出
        } else {
            char char1 = s1.charAt(p1);
            char char2 = s2.charAt(p2);
            if (char1 == char3 && char2 != char3){
                return dfs(s1,s2,s3,p1+1,p2,p3+1);
            } else if (char1 != char3 && char2 == char3){
                return dfs(s1,s2,s3,p1,p2+1,p3+1);
            } else if (char1 == char3 && char2 == char3){
                return dfs(s1,s2,s3,p1,p2+1,p3+1) || dfs(s1,s2,s3,p1+1,p2,p3+1);
            } else {
                return false;
            }
        }
    }

    /**
     * 方法二：动态规划
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    private boolean dp(String s1, String s2, String s3){
        int s1Length = s1.length(), s2Length = s2.length(), s3Length = s3.length();

        if (s1Length + s2Length != s3Length){
            return false;
        }

        boolean[][] f = new boolean[s1Length + 1][s2Length + 1];
        f[0][0] = true;
        for (int i = 0; i <= s1Length; i++){
            for (int j = 0; j <= s2Length; j++){
                int p = i+j-1;
                // 有两种情况：
                //    1、s3的第p个字符和s1的第i-1个字符一样
                //    2、s3的第p个字符和s2的第i-1个字符一样
                if (i > 0){
                    f[i][j] = f[i][j] || (f[i-1][j] && s1.charAt(i-1) == s3.charAt(p));
                }
                if (j > 0){
                    f[i][j] = f[i][j] || (f[i][j-1] && s2.charAt(j-1) == s3.charAt(p));
                }
            }
        }
        return f[s1Length][s2Length];
    }
}