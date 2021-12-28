package first;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-25 10:49
 **/
public class OneOneEightEight {
    class BoundedBlockingQueue {
        private volatile LinkedList<Integer> queue = new LinkedList<>();
        private int capacity;
        private AtomicInteger size = new AtomicInteger(0);
        private Semaphore semaphoreEnq = new Semaphore(0);
        private Semaphore semaphoreDeq = new Semaphore(0);

        public BoundedBlockingQueue(int capacity) {
            this.capacity = capacity;
        }

        public void enqueue(int element) throws InterruptedException {
            while (size.get() >= capacity) {
                semaphoreEnq.acquire();
            }
            queue.offer(element);
            size.incrementAndGet();
        }

        public int dequeue() throws InterruptedException {
            int res = -1;
            while (size.get() <= 0) {
                semaphoreDeq.acquire();
            }
            res = queue.pollFirst();
            size.decrementAndGet();
            semaphoreEnq.release();
            return res;
        }

        public int size() {
            return size.get();
        }
    }
}
