package leaddemo;

/**
 * 死锁demo。
 * @author machitao
 * @date 2021/7/4
 * @description
 */
public class DeadlockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        DeadlockDemo deadlockDemo = new DeadlockDemo();
        deadlockDemo.deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println(1);
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
