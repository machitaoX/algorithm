package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author machitao
 * @date 2021/6/22
 * @description
 */
public class NineFive {
    /**
     * 不同的二叉搜索树
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    /**
     * 深度遍历所给范围，任何一个元素都可以成为root结点
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (end < start){
            return res;
        }
        if (start == end){
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; i++){

            List<TreeNode> leftList = dfs(start,i-1);
            int leftNumber = leftList.size() == 0? 1 : leftList.size();
            List<TreeNode> rightList = dfs(i+1,end);
            int rightNumber = rightList.size() == 0? 1 : rightList.size();
            // 左子树数量x右子树数量
            for (int l = 0; l < leftNumber; l++){
                for (int r = 0; r < rightNumber; r++){
                    TreeNode root = new TreeNode(i);
                    if (leftList.size() != 0){
                        root.left = leftList.get(l);
                    }
                    if (rightList.size() != 0){
                        root.right = rightList.get(r);
                    }
                    res.add(root);
                }
            }
        }
        return res;
    }

    private static class TreeNode{
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
