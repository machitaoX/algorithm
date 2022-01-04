package second;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 11:55
 **/
public class OneFourSix {
    class DLNode {
        int key;
        int value;
        DLNode pre;
        DLNode next;
        public DLNode() {
        }
        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    class LRUCache {
        HashMap<Integer, DLNode> map;
        DLNode head;
        DLNode tail;
        int capacity;
        int size;
        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            this.head = new DLNode();
            this.tail = new DLNode();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public int get(int key) {
            DLNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLNode node = map.get(key);
            if (node == null) {
                if (size == capacity) {
                    DLNode moveNode = tail.pre;
                    remove(moveNode);
                    map.remove(moveNode.key);
                }
                node = new DLNode(key, value);
                insertIntoHead(node);
                map.put(key, node);
            } else {
                moveToHead(node);
                node.value = value;
            }
        }

        private void remove(DLNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
            size--;
        }

        private void moveToHead(DLNode node) {
            remove(node);
            insertIntoHead(node);
        }

        private void insertIntoHead(DLNode node) {
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
            size++;
        }
    }
}
