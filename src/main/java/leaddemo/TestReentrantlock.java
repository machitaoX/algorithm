package leaddemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-18 18:52
 **/
public class TestReentrantlock {

    public static void main(String[] args) {
        final int[] i = {0};
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i[0] != 100) {
                        System.out.println(i[0]);
                        i[0]++;
                        condition2.signal();
                        condition1.await();
                    }
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(100);
                    while (i[0] != 100) {
                        System.out.println(i[0]);
                        i[0]++;
                        condition3.signal();
                        condition2.await();
                    }
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(200);
                    while (i[0] != 100) {
                        System.out.println(i[0]);
                        i[0]++;
                        condition1.signal();
                        condition3.await();
                    }
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
