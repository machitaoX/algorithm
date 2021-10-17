package first;

/**
 * @author machitao
 * @date 2021/10/17
 * @description
 */
public class OneFourEight {
    public ListNode sortList(ListNode head) {
        return dfs(head);
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode fakeHead = new ListNode();
        ListNode move = fakeHead, move_1 = one, move_2 = two;
        while (move_1 != null && move_2 != null) {
            if (move_1.val <= move_2.val) {
                move.next = move_1;
                move = move_1;
                move_1 = move_1.next;
            } else {
                move.next = move_2;
                move = move_2;
                move_2 = move_2.next;
            }
        }
        move.next = move_1 == null ? move_2 : move_1;
        return fakeHead.next;
    }

    private ListNode dfs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick.next == null) {
                break;
            }
            quick = quick.next;
        }
        ListNode fakeHead = slow.next;
        slow.next = null;
        ListNode one = dfs(head);
        ListNode two = dfs(fakeHead);
        return merge(one, two);
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
