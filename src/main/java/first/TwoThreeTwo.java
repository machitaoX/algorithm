package first;

import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-22 12:54
 **/
public class TwoThreeTwo {
    class MyQueue {
        Stack<Integer> stackLeft;
        Stack<Integer> stackRight;

        public MyQueue() {
            stackLeft = new Stack<>();
            stackRight = new Stack<>();
        }

        public void push(int x) {
            stackLeft.push(x);
        }

        public int pop() {
            if (stackRight.isEmpty()) {
                while (!stackLeft.empty()) {
                    stackRight.push(stackLeft.pop());
                }
            }
            if (stackRight.isEmpty()) {
                return -1;
            }
            return stackRight.pop();
        }

        public int peek() {
            if (stackRight.isEmpty()) {
                while (!stackLeft.empty()) {
                    stackRight.push(stackLeft.pop());
                }
            }
            if (stackRight.isEmpty()) {
                return -1;
            }
            return stackRight.peek();
        }

        public boolean empty() {
            return stackLeft.isEmpty() && stackRight.isEmpty();
        }
    }
}
