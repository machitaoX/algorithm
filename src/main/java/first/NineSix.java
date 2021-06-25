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
     * 和95题同理
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

    private static class TreeNode{
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
