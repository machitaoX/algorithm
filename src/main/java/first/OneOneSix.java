package first;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-08-28 23:01
 **/
public class OneOneSix {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node left = null;
            Node right = null;
            for (int i = 0; i < size; i++) {
                left = right;
                if (i == 0) {
                    left = queue.poll();
                }
                right = queue.poll();
                left.next = right;
                queue.offer(left.left);
                queue.offer(left.right);
                if (right != null) {
                    queue.add(right.left);
                    queue.add(right.right);
                }
            }
        }
        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
