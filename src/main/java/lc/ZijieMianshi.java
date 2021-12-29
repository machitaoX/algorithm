package lc;

/**
 * @author machitao
 * @date 2021/12/27
 * @description
 */
public class ZijieMianshi {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        two.next = three;
        Node res = reverse(one);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static Node reverse (Node root) {
        Node fakeHead = new Node(-1);
        Node pre = fakeHead;
        Node move = root;
        Node post = null;
        if (move != null) {
            post = root.next;
        }
        while (move != null) {
            move.next = pre;
            pre = move;
            move = post;
            if (post != null) {
                post = post.next;
            }
        }
        fakeHead.next = null;

        return pre;
    }

    private static class Node {

        public Node(int val) {
            this.val = val;
        }
        private int val;

        private Node next;
    }
}
