package first;

/**
 * @author machitao
 * @date 2021/6/21
 * @description
 */
public class NineTwo {

    /**
     * 方法一：单独把链表切出来
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 假的头节点，防止分类讨论
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        // 找到left前一个位置pre
        ListNode pre = fakeHead;
        for (int i = 0; i < left -1; i++){
            pre = pre.next;
        }

        // 找到right位置
        ListNode rightNode = pre;
        for (int i = 0; i < right - left +1; i++){
            rightNode = rightNode.next;
        }

        // 将链表单独拿出来，不要和原链表有接触
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        // 反转链表
        reverse(leftNode);
        leftNode.next = curr;
        pre.next = rightNode;
        return fakeHead.next;
    }


    /**
     * 方法二：穿针引线法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right){
        return null;
    }

    /**
     * 反转头节点,单独一个链表，不与其他链表 相关联/有交集
     * @param head 头节点
     * @return
     */
    private void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
