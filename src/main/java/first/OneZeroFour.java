package first;

/**
 * @author machitao
 * @date 2021/7/23
 * @description
 */
public class OneZeroFour {
    public int maxDepth(TreeNode root) {
        return max(root);
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(max(root.left), max(root.right));
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
