package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-08-27 22:55
 **/
public class OneOneFour {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> res = new ArrayList<>();
        pre(root, res);
        TreeNode lastNode = root;
        for (int i = 1; i < res.size(); i++) {
            lastNode.right = res.get(i);
            lastNode = lastNode.right;
        }
    }

    private void pre(TreeNode root, List<TreeNode> treeNodeList) {
        if (root == null) {
            return;
        }
        treeNodeList.add(root);
        pre(root.left, treeNodeList);
        root.left = null;
        pre(root.right, treeNodeList);
        root.right = null;
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
