package first;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-14 22:00
 **/
public class OneFourSix {
    private static class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int capacity;
        private int used;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            used = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode dLinkedNode = cache.get(key);
            if (dLinkedNode == null) {
                return -1;
            }
            moveToHead(dLinkedNode);
            return dLinkedNode.value;
        }

        public void put(int key, int value) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            DLinkedNode dLinkedNode = cache.get(key);
            if (dLinkedNode != null) {
                remove(dLinkedNode);
            } else if (used >= capacity){
                cache.remove(tail.pre.key);
                remove(tail.pre);
            }
            cache.put(key, newNode);
            insertToHead(newNode);
        }

        private void moveToHead(DLinkedNode dLinkedNode) {
            remove(dLinkedNode);
            insertToHead(dLinkedNode);
        }

        private void insertToHead(DLinkedNode dLinkedNode) {
            used++;
            dLinkedNode.next = head.next;
            head.next.pre = dLinkedNode;
            head.next = dLinkedNode;
            dLinkedNode.pre = head;
        }

        private void remove(DLinkedNode dLinkedNode) {
            used--;
            dLinkedNode.pre.next = dLinkedNode.next;
            dLinkedNode.next.pre = dLinkedNode.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
    }
}
