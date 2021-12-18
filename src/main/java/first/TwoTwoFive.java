package first;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-18 16:15
 **/
public class TwoTwoFive {
    class MyStack {
        Queue<Integer> queueOne;
        Queue<Integer> queueTwo;
        int k = 0;
        public MyStack() {
            queueOne = new LinkedList<>();
            queueTwo = new LinkedList<>();
        }

        public void push(int x) {
            if (queueTwo.isEmpty()) {
                queueOne.offer(x);
            } else {
                queueTwo.offer(x);
            }
            k = x;
        }

        public int pop() {
            if (queueTwo.isEmpty()) {
                while (queueOne.size() != 1) {
                    k = queueOne.poll();
                    queueTwo.offer(k);
                }
                return queueOne.poll();
            } else {
                while (queueTwo.size() != 1) {
                    k = queueTwo.poll();
                    queueOne.offer(k);
                }
                return queueTwo.poll();
            }
        }

        public int top() {
            return k;
        }

        public boolean empty() {
            return queueTwo.isEmpty() && queueOne.isEmpty();
        }
    }
}
