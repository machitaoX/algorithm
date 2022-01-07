package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-07 17:17
 **/
public class Jianzhi06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        while (head != null) {
            temp.add(0, head.val);
            head = head.next;
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
