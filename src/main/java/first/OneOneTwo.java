package first;

/**
 * @author machitao
 * @date 2021/8/22
 * @description
 */
public class OneOneTwo {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return has(root, targetSum, 0);
    }

    private boolean has(TreeNode root, int targetSum, int lastSum) {
        if (root == null) {
            return false;
        }
        int lastSumFake = lastSum + root.val;
        if (root.left == null && root.right == null) {
            if (lastSumFake == targetSum) {
                return true;
            }
            return false;
        }
        return has(root.left, targetSum, lastSumFake) || has(root.right, targetSum, lastSumFake);
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
