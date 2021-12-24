package first;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-24 12:52
 **/
public class OneOneOneFour {
    class Foo {
        private ReentrantLock lock;
        private Condition condition2;
        private Condition condition3;
        int one = 0, two = 0;

        public Foo() {
            lock = new ReentrantLock();
            condition2 = lock.newCondition();
            condition3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            lock.lock();
            try {
                printFirst.run();
                one = 1;
                condition2.signal();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            lock.lock();
            try {
                if (one != 1) {
                    condition2.await();
                }
                printSecond.run();
                two = 1;
                condition3.signal();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            lock.lock();
            try {
                if (two != 1) {
                    condition3.await();
                }
                printThird.run();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
