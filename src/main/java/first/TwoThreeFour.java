package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-22 13:13
 **/
public class TwoThreeFour {
    public boolean isPalindrome(ListNode head) {
        ListNode slowPoint = head, quickPoint = head;
        while (quickPoint != null && quickPoint.next != null) {
            slowPoint = slowPoint.next;
            quickPoint = quickPoint.next;
            quickPoint = quickPoint.next;
        }
        ListNode tail = reverse(slowPoint);
        slowPoint = head;
        while (tail != null && head != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = new ListNode(), mid = start, after = start.next;
        while (mid != null) {
            mid.next = pre;
            pre = mid;
            mid = after;
            if (mid != null) {
                after = mid.next;
            }
        }
        start.next = null;
        return pre;
    }
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
