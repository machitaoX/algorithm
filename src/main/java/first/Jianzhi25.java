package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 10:07
 **/
public class Jianzhi25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode move = fakeHead, move1 = l1, move2 = l2;
        while (move1 != null && move2!= null) {
            if (move1.val < move2.val) {
                move.next = move1;
                move = move1;
                move1 = move1.next;
            } else {
                move.next = move2;
                move = move2;
                move2 = move2.next;
            }
        }
        move.next = move1 == null ? move2 : move1;
        return fakeHead.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
