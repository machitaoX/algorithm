package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-08 14:43
 **/
public class Jianzhi24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead, move = head, post = null;
        while (move != null) {
            post = move.next;
            move.next = pre;
            pre = move;
            move = post;
        }
        head.next = null;
        return pre;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
