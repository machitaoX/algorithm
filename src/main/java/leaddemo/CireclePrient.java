package leaddemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author machitao
 * @date 2021/11/7
 * @description
 */
public class CireclePrient {
    public static Lock lock = new ReentrantLock();

    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();
    public static void main(String[] args) {

    }
}
