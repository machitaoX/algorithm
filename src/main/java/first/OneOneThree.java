package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/8/22
 * @description
 */
public class OneOneThree {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        get(root, targetSum, 0, res, new ArrayList<>());
        return res;
    }

    private void get(TreeNode root, int targetSum, int lastSum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        int sum = lastSum + root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum){
                List<Integer> ok = new ArrayList<>(temp);
                res.add(ok);
            }
        } else {
            if (root.left != null) {
                get(root.left, targetSum, sum, res, temp);
            }
            if (root.right != null) {
                get(root.right, targetSum, sum, res, temp);
            }
        }
        temp.remove(temp.size() - 1);
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
