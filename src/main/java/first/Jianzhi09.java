package first;

import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 09:49
 **/
public class Jianzhi09 {
    class CQueue {
        Stack<Integer> inPut;
        Stack<Integer> outPut;
        public CQueue() {
            inPut = new Stack<>();
            outPut = new Stack<>();
        }

        public void appendTail(int value) {
            inPut.push(value);
        }

        public int deleteHead() {
            if (outPut.isEmpty()) {
                while (!inPut.isEmpty()) {
                    outPut.push(inPut.pop());
                }
            }
            if (outPut.isEmpty()) {
                return -1;
            }
            return outPut.pop();
        }
    }
}
