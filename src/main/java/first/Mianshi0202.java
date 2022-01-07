package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-07 13:54
 **/
public class Mianshi0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
