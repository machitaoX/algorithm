package first;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-08 22:27
 **/
public class OneSevenThree {
    class BSTIterator {

        public TreeNode root;

        public int flag;

        public List<TreeNode> date;

        public BSTIterator(TreeNode root) {
            this.root = root;
        }

        public int next() {
            if (root == null) {
                return -1;
            }
            if (date == null) {
                date = new ArrayList<>();
                medium(date, root);
            }
            int val = date.get(flag).val;
            flag++;
            return val;
        }

        public boolean hasNext() {
            if (root == null) {
                return false;
            }
            if (date == null) {
                date = new ArrayList<>();
                medium(date, root);
            }
            if (flag < date.size()){
                return true;
            }
            return false;
        }

        private void medium(List<TreeNode> date, TreeNode root) {
            if (root == null) {
                return;
            }
            medium(date, root.left);
            date.add(root);
            medium(date, root.right);
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
