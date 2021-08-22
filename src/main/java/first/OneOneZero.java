package first;

/**
 * @author machitao
 * @date 2021/8/22
 * @description
 */
public class OneOneZero {

    public boolean isBalanced(TreeNode root) {
        return isBalance(root);
    }

    private int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
    }

    private boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1)
                && isBalance(root.left)
                && isBalance(root.right);
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
