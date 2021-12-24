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
        private Condition condition1;
        private Condition condition2;
        private Condition condition3;

        public Foo() {
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
            condition3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            lock.lock();
            try {
                printFirst.run();
                condition2.signal();
                condition1.await();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            lock.lock();
            try {
                printSecond.run();
                condition3.signal();
                condition2.await();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            lock.lock();
            try {
                printThird.run();
                condition1.signal();
                condition3.await();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
