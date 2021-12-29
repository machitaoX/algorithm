package leaddemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
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
        Semaphore sam1 = new Semaphore(1);
        Semaphore sam2 = new Semaphore(0);
        Semaphore sam3 = new Semaphore(0);
        AtomicInteger signal = new AtomicInteger(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sam1.acquire();
                        if (signal.get() > 100) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "  " + signal.getAndIncrement());
                        sam2.release();
                    } catch (Exception e) {
                        // todo something
                    }
                }
                sam2.release();
            }
        }, "thread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sam2.acquire();
                        if (signal.get() > 100) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName()+ "  " + signal.getAndIncrement());
                        sam3.release();
                    } catch (Exception e) {
                        // todo something
                    }
                }
                sam3.release();
            }
        }, "thread-2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sam3.acquire();
                        if (signal.get() > 100) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "  " + signal.getAndIncrement());
                        sam1.release();
                    } catch (Exception e) {
                        // todo something
                    }
                }
                sam1.release();
            }
        }, "thread-3").start();
    }
}
