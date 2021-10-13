package first;

/**
 * @author machitao
 * @date 2021/10/12
 * @description
 */
public class OneFourThree {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, quick = head;
        ListNode newHead = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);
        merge(newHead, head);
    }

    /**
     * 反转链表
     * @param newHead
     * @return
     */
    private ListNode reverse(ListNode newHead) {
        ListNode left = newHead, medium = newHead.next;
        if (medium == null) {
            return newHead;
        }
        ListNode right = medium.next;
        while (true) {
            medium.next = left;
            left = medium;
            medium = right;
            if (medium == null) {
                break;
            }
            right = right.next;
        }
        newHead.next = null;
        return left;
    }

    private void merge(ListNode newHead, ListNode head) {
        ListNode move = head, ready_1 = head.next, ready_2 = newHead;
        while (ready_1 != null || ready_2 != null) {
            if (ready_2 != null) {
                move.next = ready_2;
                move = ready_2;
                ready_2 = ready_2.next;
            }
            if (ready_1 != null) {
                move.next = ready_1;
                move = ready_1;
                ready_1 = ready_1.next;
            }
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
