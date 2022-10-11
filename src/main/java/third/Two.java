package third;

/**
 * @author machitao
 * @date 2022/10/11
 * @description
 */
public class Two {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodeL1 = l1, nodeL2 = l2;
        boolean passOne = false;
        while (true) {
            int tempVal = nodeL1.val + nodeL2.val + (passOne ? 1 : 0);
            if (tempVal > 9) {
                passOne = true;
                nodeL1.val = tempVal % 10;
            } else {
                passOne = false;
                nodeL1.val = tempVal;
            }
            if (nodeL1.next == null && nodeL2.next == null) {
                if (passOne) {
                    nodeL1.next = new ListNode(1);
                }
                return l1;
            } else if (nodeL1.next == null) {
                nodeL1.next = new ListNode(0);
            } else if (nodeL2.next == null) {
                nodeL2.next = new ListNode(0);
            }
            nodeL1 = nodeL1.next;
            nodeL2 = nodeL2.next;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
