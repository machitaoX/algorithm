package second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author machitao
 * @date 2021/12/29
 * @description
 */
public class OneNineNine {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int i = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int temp = 0;
            while (i != 0) {
                i--;
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                    temp++;
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                    temp++;
                }
                if (i == 0) {
                    res.add(tempNode.val);
                }
            }
            i = temp;
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
