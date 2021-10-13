package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/10/13
 * @description
 */
public class OneFourFour {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(res, root.left);
        dfs(res, root.right);
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
