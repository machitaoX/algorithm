package first;

import java.util.HashMap;

/**
 * @author machitao
 * @date 2021/7/23
 * @description
 */
public class OneZeroFive {
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0,preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder,
                           int[] inorder, int preleft, int preright, int inleft, int inright) {

        if (preleft > preright) {
            return null;
        }
        int perOrderRoot = preleft;
        int inOrderRoot = inorderMap.get(preorder[perOrderRoot]);
        int newPerRight = preleft+inOrderRoot-inleft;
        TreeNode treeNode = new TreeNode(preorder[perOrderRoot]);
        treeNode.left = build(preorder, inorder, preleft +1, newPerRight, inleft,inOrderRoot-1);
        treeNode.right = build(preorder, inorder, newPerRight+1, newPerRight, inOrderRoot+1,inright);
        return treeNode;
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
