package first;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-24 13:21
 **/
public class OneOneOneFive {
    class FooBar {
        private int n;
        private ReentrantLock lock;
        private Condition condition1;
        private Condition condition2;
        private int move = 0;

        public FooBar(int n) {
            this.n = n;
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (move != 0) {
                        condition1.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    move = 1;
                    condition2.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (move != 1) {
                        condition2.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    move = 0;
                    condition1.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
