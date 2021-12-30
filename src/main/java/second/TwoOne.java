package second;


/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 19:06
 **/
public class TwoOne {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode();
        ListNode move = fakeHead;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1Head != null && l2Head != null) {
            if (l1Head.val > l2Head.val) {
                move.next = l2Head;
                l2Head = l2Head.next;

            } else {
                move.next = l1Head;
                l1Head = l1Head.next;
            }
            move = move.next;
        }
        move.next = l1Head != null ? l1Head : l2Head;
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
