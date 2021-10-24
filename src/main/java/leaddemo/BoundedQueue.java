package leaddemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-24 15:00
 **/
public class BoundedQueue<T> {
    private Object[] items;

    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    private BoundedQueue (int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
                items[addIndex] = t;
                if (++addIndex == items.length) {
                    addIndex = 0;
                }
                ++count;
                notEmpty.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
                Object x = items[removeIndex];
                if (++removeIndex == items.length) {
                    removeIndex = 0;
                }
                --count;
                notFull.signal();
                return (T) x;
            }
        } finally {
            lock.unlock();
        }
        return null;
    }
}
