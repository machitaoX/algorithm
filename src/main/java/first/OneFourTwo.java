package first;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author machitao
 * @date 2021/10/12
 * @description
 */
public class OneFourTwo {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new LinkedHashSet<>();
        ListNode res = head;
        while (res != null && !set.contains(res)) {
            set.add(res);
            res = res.next;
        }
        return res;
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
