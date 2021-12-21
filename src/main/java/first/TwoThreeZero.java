package first;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-21 17:04
 **/
public class TwoThreeZero {
    PriorityQueue<Integer> p = null;
    public int kthSmallest(TreeNode root, int k) {
        p = new PriorityQueue<>(k, Comparator.naturalOrder());
        dfs(root);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = p.poll();
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        p.offer(root.val);
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
