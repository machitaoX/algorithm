package forth;

/**
 * @program: algorithm
 * @description: 19
 * @author: machitao
 * @create: 2024-06-24 22:57
 **/
public class OneNine {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode before = head;
        ListNode after = fakeHead;
        for (int i = 0; i < n; i++) {
            before = before.next;
        }

        while (before != null) {
            before = before.next;
            after = after.next;
        }
        after.next = after.next.next;
        return fakeHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
