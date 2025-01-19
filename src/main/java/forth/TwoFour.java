package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2025-01-19 22:27
 **/
public class TwoFour {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode left = fakeHead, medium = head;
        if (medium == null || medium.next == null) {
            return head;
        }
        ListNode right = head.next;
        while (true) {
            swap(left, medium, right);
            if (medium.next == null || medium.next.next == null) {
                break;
            }
            left = medium;
            medium = medium.next;
            right = medium.next;
        }
        return fakeHead.next;
    }

    private void swap(ListNode left, ListNode medium, ListNode right) {
        left.next = right;
        medium.next = right.next;
        right.next = medium;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
