package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-18 16:48
 **/
public class TwoTwoSix {
    public TreeNode invertTree(TreeNode root) {
        return reverse(root);
    }

    private TreeNode reverse(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = reverse(root.left);
        TreeNode right = reverse(root.right);
        root.left = right;
        root.right = left;
        return root;
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
