package first;

/**
 * @author machitao
 * @date 2021/8/22
 * @description
 */
public class OneOneOne {
    public int minDepth(TreeNode root) {
        return min(root);
    }

    private int min(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return min(root.right);
        }
        if (root.left != null && root.right == null) {
            return min(root.left);
        }
        return Math.min(min(root.left), min(root.right)) + 1;
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
