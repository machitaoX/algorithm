package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-24 13:35
 **/
public class OneFiveSix {
    private TreeNode newRoot = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        postOrder(root);
        return newRoot;
    }
    private TreeNode postOrder(TreeNode root) {
        if(root == null) {
            return null;
        }
        if (root.left == null) {
            if (newRoot == null) {
                newRoot = root;
            }
            return root;
        }

        TreeNode fakeLeft = postOrder(root.left);
        root.left = null;
        fakeLeft.right = root;
        fakeLeft.left = postOrder(root.right);
        root.right = null;
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
