package first;

/**
 * @author machitao
 * @date 2021/10/23
 * @description
 */
public class OneFiveFive {

    private static class MinStack {
        private Node minNode;

        private Node tail;

        private Node head;

        public MinStack() {
            head = new Node(Integer.MAX_VALUE);
            tail = head;
            minNode = head;
        }

        public void push(int val) {
            Node newNode = new Node(val);
            tail.next = newNode;
            newNode.pre = tail;
            tail = tail.next;
            if (val < minNode.val) {
                minNode = newNode;
            }
        }

        public void pop() {
            if (tail == minNode) {
                Node temp = minNode.pre;
                int val = minNode.pre.val;
                while (temp != head) {
                    if (val < minNode.val) {
                        minNode = temp;
                    }
                    temp = temp.pre;
                    val = temp.val;
                }
            }
            Node newTail = tail.pre;
            tail.pre = null;
            tail = newTail;
            tail.next = null;
        }

        public int top() {
            if (head == tail) {
                return -1;
            } else {
                return tail.val;
            }
        }

        public int getMin() {
                return minNode.val;
        }
    }

    private static class Node {
        int val;

        Node next;

        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }
}
