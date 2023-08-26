package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-08-26 19:34
 **/
public class Two {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode();
        ListNode move = head;
        int pass = 0;
        while (p1 != null || p2 != null || pass != 0) {
            int sum = 0;
            if (p1 != null && p2 != null) {
                sum = p1.val + p2.val + pass;
            } else if (p1 != null) {
                sum = p1.val + pass;
            } else if (p2 != null) {
                sum = p2.val + pass;
            } else {
                sum = pass;
            }

            pass = sum / 10;
            sum = sum % 10;

            move.next = new ListNode(sum);
            move = move.next;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
