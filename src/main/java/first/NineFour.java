package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/6/22
 * @description
 */
public class NineFour {
    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    /**
     * 递归遍历
     * @param res
     * @param root
     */
    private void dfs(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }

    private static class TreeNode{
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
