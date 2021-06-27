package first;

/**
 * @author machitao
 * @date 2021/6/27
 * @description
 */
public class NineEight {
    /**
     * 验证二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return bfsCheck(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /**
     * 广度优先遍历
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean bfsCheck(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return bfsCheck(root.left,min,root.val) && bfsCheck(root.right,root.val,max);
    }

    private class TreeNode {
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
