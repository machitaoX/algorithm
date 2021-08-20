package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-08-13 23:22
 **/
public class OneZeroNine {
    public TreeNode sortedListToBST(ListNode head) {
        System.out.println("test");
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = findMid(left, right);
        TreeNode treeNode = new TreeNode(mid.val);
        treeNode.left = dfs(left, mid);
        treeNode.right = dfs(mid.next, right);
        return treeNode;
    }

    private ListNode findMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;

        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
    }
}
