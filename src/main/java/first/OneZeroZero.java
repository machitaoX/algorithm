package first;

/**
 * @author machitao
 * @date 2021/7/5
 * @description
 */
public class OneZeroZero {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorder(p, q);
    }

    /**
     * 中序遍历
     * @param p
     * @param q
     * @return
     */
    private boolean inorder(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
            return false;
        }
        return inorder(p.left, q.left) && inorder(p.right, q.right);
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
