package lc;

import java.util.List;

/**
 * @author machitao
 * @date 2021/12/30
 * @description
 */
public class ZijieMianshi2 {
    private boolean backtrack(Node root, int target, List<Node> temp) {
        if (root == null) {
            return false;
        }
        target = target - root.val;
        temp.add(root);
        if (0 == target ) {
            return true;
        }
        if (backtrack(root.left, target, temp) || backtrack(root.right, target, temp)) {
            return true;
        }
        temp.remove(temp.size() - 1);
        return false;
    }

    class Node {
        int val;
        Node left;
        Node right;
    }
}
