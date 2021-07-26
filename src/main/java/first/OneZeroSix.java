package first;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author machitao
 * @date 2021/7/26
 * @description
 */
public class OneZeroSix {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode dfs(int[] inorder, int inLeft, int inRight, int[] postorder, int posLeft, int posRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posRight]);
        int split = map.get(postorder[posRight]);
        int inNewRight = split - 1;
        int inNewLeft = split + 1;
        int posNewLeft = posRight - inRight + split;
        root.left = dfs(inorder, inLeft, inNewRight, postorder, posLeft, posNewLeft - 1 );
        root.right = dfs(inorder, inNewLeft, inRight, postorder, posNewLeft, posRight - 1);
        return root;
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
