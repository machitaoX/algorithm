package first;

/**
 * @author machitao
 * @date 2021/6/25
 * @description
 */
public class NineSix {

    /**
     * 不同的搜索二叉树
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return dfs(1,n);
    }

    /**
     * 方法一：和95题同理递归，但是会超时
     * @param start
     * @param end
     * @return
     */
    private int dfs(int start, int end){
        if (start >= end){
            return 1;
        }
        int count = 0;
        for (int i = start; i <= end; i++){
            count = count + (dfs(start, i-1) * dfs(i+1,end));
        }
        return count;
    }

    /**
     * 方法二：动态规划
     * @param n
     * @return
     */
    private int dp(int n){
        // 元素数量为n的二叉树会有多少种可能
        int[] dpArray = new int[n+1];
        // 空树的话是一种
        dpArray[0] = 1;
        // 一个元素的话也是一种
        dpArray[1] = 1;

        // 元素个数的遍历
        for (int i = 2; i < n+1; i++){
            for (int j = 1; j <= i; j++){
                dpArray[i] += dpArray[j-1] * dpArray[i-j];
            }
        }
        return dpArray[n];
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
