package first;

import java.util.Stack;

/**
 * @author machitao
 * @date 2021/10/23
 * @description
 */
public class OneFiveFive {
    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> inPut;
        Stack<Integer> minPut;
        public MinStack() {
            inPut = new Stack<>();
            minPut = new Stack<>();
        }

        public void push(int val) {
            inPut.push(val);
            if (minPut.isEmpty()) {
                minPut.push(val);
            } else {
                minPut.push(Math.min(minPut.peek(), val));
            }
        }

        public void pop() {
            inPut.pop();
            minPut.pop();
        }

        public int top() {
            return inPut.peek();
        }

        public int getMin() {
            return minPut.peek();
        }
    }
}
