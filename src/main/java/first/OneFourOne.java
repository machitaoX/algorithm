package first;

/**
 * @author machitao
 * @date 2021/10/11
 * @description
 */
public class OneFourOne {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, quick = head.next;
        while (slow != null && slow != null && quick != null) {
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }
        }
        return false;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
