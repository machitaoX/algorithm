package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 19:08
 **/
public class Jianzhi52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode startA = headA, startB = headB;
        boolean routeNull = false;
        while (true) {
            if (startA == startB) {
                return startA;
            }
            startA = startA.next;
            if (startA == null) {
                if (!routeNull) {
                    routeNull = true;
                    startA = headB;
                } else {
                    return null;
                }
            }
            startB = startB.next;
            if (startB == null) {
                startB = headA;
            }
        }
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
