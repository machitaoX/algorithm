package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-27 19:17
 **/
public class TwoFiveSeven {
    List<String> res;
    StringBuffer stringBuffer ;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        stringBuffer = new StringBuffer();
        backtracing(root);
        return res;
    }

    private void backtracing(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuffer.append(root.val).append("->");
        int length = (root.val + "").length();
        if (root.left == null && root.right == null) {
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
            res.add(stringBuffer.toString());
            stringBuffer.delete(stringBuffer.length() - length, stringBuffer.length());
            return;
        }
        backtracing(root.left);
        backtracing(root.right);
        stringBuffer.delete(stringBuffer.length() - length - 2, stringBuffer.length());
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
