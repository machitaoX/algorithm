package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-13 23:00
 **/
public class TwoTwoTwo {
    private int res = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        res++;
        dfs(root.left);
        dfs(root.right);
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
