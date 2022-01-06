package first;

import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-06 19:22
 **/
public class Mianshi0302 {
    class MinStack {

        Stack<Integer> stackPut;
        Stack<Integer> stackMin;
        /** initialize your data structure here. */
        public MinStack() {
            stackPut = new Stack<>();
            stackMin = new Stack<>();
            stackMin.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stackPut.push(x);
            stackMin.push(Math.min(x, stackMin.peek()));
        }

        public void pop() {
            stackPut.pop();
            stackMin.pop();
        }

        public int top() {
            return stackPut.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }
    }
}
