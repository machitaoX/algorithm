package second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-28 16:31
 **/
public class OneZeroTwo {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        int beforeCount = 1;
        while (!queue.isEmpty()) {
            int newCount = 0;
            List<Integer> tempList = new ArrayList<>();
            while (beforeCount != 0) {
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                beforeCount--;
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                    newCount++;
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                    newCount++;
                }
            }
            res.add(tempList);
            beforeCount = newCount;
        }
        return res;
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
