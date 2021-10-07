package first;

import java.util.HashMap;
import java.util.Map;

/**
 * @author machitao
 * @date 2021/9/29
 * @description
 */
public class OneThreeEight {
    Map<Node, Node> cacheNode = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cacheNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cacheNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
