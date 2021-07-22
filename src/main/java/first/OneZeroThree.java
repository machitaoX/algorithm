package first;

import java.util.*;

/**
 * @author machitao
 * @date 2021/7/22
 * @description
 */
public class OneZeroThree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        stackA.push(root);
        boolean left = true;

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            int count = stackA.size() == 0 ? stackB.size() : stackA.size();
            Stack<TreeNode> empty;
            Stack<TreeNode> full;
            if (stackA.size() != 0) {
                full = stackA;
                empty = stackB;
            } else {
                full = stackB;
                empty = stackA;
            }
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode tempNode = full.pop();
                temp.add(tempNode.val);
                if (left) {
                    if (tempNode.left != null) {
                        empty.push(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        empty.push(tempNode.right);
                    }
                } else {
                    if (tempNode.right != null) {
                        empty.push(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        empty.push(tempNode.left);
                    }
                }
            }
            res.add(temp);
            left = !left;
        }
        return res;
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
