package forth;

/**
 * @program: algorithm
 * @description: 21
 * @author: machitao
 * @create: 2024-07-11 00:24
 **/
public class TwoOne {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode fake = new ListNode();
        ListNode move = fake;
        while (list2 != null && list1 != null) {
            if (list1.val < list2.val) {
                move.next = list1;
                list1 = list1.next;
                move = move.next;
            } else {
                move.next = list2;
                list2 = list2.next;
                move = move.next;
            }
        }
        if (list1 == null) {
            move.next = list2;
        } else {
            move.next = list1;
        }
        return fake.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
