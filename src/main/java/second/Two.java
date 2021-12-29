package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 10:41
 **/
public class Two {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode move_1 = l1;
        ListNode move_2 = l2;
        ListNode resHead = new ListNode();
        ListNode move = resHead;
        while (move_1 != null || move_2 != null) {
            int move1Value = move_1 == null ? 0 : move_1.val;
            int move2Value = move_2 == null ? 0 : move_2.val;
            int temp = move1Value + move2Value + add;
            add = temp / 10;
            temp = temp % 10;
            move.next = new ListNode(temp);
            move = move.next;
            if (move_1 != null) {
                move_1 = move_1.next;
            }
            if (move_2 != null) {
                move_2 = move_2.next;
            }
        }
        if (add != 0) {
            move.next = new ListNode(1);
        }
        return resHead.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
