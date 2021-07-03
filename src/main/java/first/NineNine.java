package first;


import java.util.ArrayList;
import java.util.List;

/**
 * 99题。
 * @author machitao
 * @date 2021/6/27
 * @description
 */
public class NineNine {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    /**
     * 中序遍历
     * @param root
     * @param res
     */
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    /**
     * 找到需要两个结点
     * 第一个结点 Ai > Ai+1中的Ai
     * 第二个结点 Aj > Aj+1中的Aj+1
     * @param nums
     * @return
     */
    private int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                // 处理思想太精彩了
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     * 广度优先遍历，更改结点数值
     * @param root
     * @param count
     * @param x
     * @param y
     */
    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null){
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0){
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
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
