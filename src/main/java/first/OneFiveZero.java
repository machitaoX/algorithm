package first;

import java.util.Stack;

/**
 * @author machitao
 * @date 2021/10/17
 * @description
 */
public class OneFiveZero {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("*".equals(tokens[i])) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(first * second);
            } else if ("/".equals(tokens[i])) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second / first);
            } else if ("-".equals(tokens[i])) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second - first);
            } else if ("+".equals(tokens[i])) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second + first);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
