package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-24 17:57
 **/
public class OneSixZero {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a == b) {
                return a;
            }
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return null;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
