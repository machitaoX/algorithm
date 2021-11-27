package first;

/**
 * @author machitao
 * @date 2021/11/27
 * @description
 */
public class TwoZeroThree {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0, head);
        ListNode pre = fakeHead;
        ListNode move = head;
        while (move != null) {
            if (move.val == val) {
                pre.next = move.next;
                move.next = null;
                move = pre.next;
                continue;
            }
            pre = move;
            move = move.next;
        }
        return fakeHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
