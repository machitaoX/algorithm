package second;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-28 17:12
 **/
public class OneZeroFive {
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode dfs(int inorderStart, int inorderEnd,
                         int preorderStart, int preorderEnd,
                         int[] preorder, int[] inorder) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        int inorderIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftLength = inorderIndex - inorderStart;
        int nextPreorderEnd = preorderStart + leftLength;
        root.left = dfs(inorderStart, inorderIndex - 1,preorderStart + 1, nextPreorderEnd ,preorder, inorder);
        root.right = dfs(inorderIndex + 1, preorderEnd, nextPreorderEnd + 1, preorderEnd,preorder, inorder);
        return root;
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
