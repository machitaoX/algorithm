package first;

import java.util.*;

/**
 * @author machitao
 * @date 2021/7/11
 * @description
 */
public class OneZeroTwo {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 用两个队列模拟两层树
        // todo:优化点用一个值来表示当层有多少个结点
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root);
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            List<Integer> temp = null;
            if (leftQueue.isEmpty()) {
                temp = bfs(rightQueue, leftQueue);
            } else {
                temp = bfs(leftQueue, rightQueue);
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * 将第一个queue中元素的左右子树放到第二个queue中
     * @param firstQueue
     * @param secondQueue
     * @return
     */
    private List<Integer> bfs(Queue<TreeNode> firstQueue, Queue<TreeNode> secondQueue) {
        List<Integer> temp = new ArrayList<>();
        while (!firstQueue.isEmpty()) {
            TreeNode treeNode = firstQueue.poll();
            temp.add(treeNode.val);
            if (treeNode.left != null) {
                secondQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                secondQueue.add(treeNode.right);
            }
        }
        return temp;
    }

    /**
     *
     */
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
