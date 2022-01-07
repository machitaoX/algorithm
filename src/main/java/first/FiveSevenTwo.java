package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-06 22:56
 **/
public class FiveSevenTwo {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }
    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (check(root, subRoot)) {
            return true;
        }
        if (root != null) {
            return dfs(root.left, subRoot) || dfs(root.right, subRoot);
        }
        return false;
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
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
