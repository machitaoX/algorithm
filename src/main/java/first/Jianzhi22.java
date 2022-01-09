package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 09:59
 **/
public class Jianzhi22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
