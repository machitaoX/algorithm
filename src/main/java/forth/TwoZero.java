package forth;

import java.util.Stack;

/**
 * @program: algorithm
 * @description: 20
 * @author: machitao
 * @create: 2024-07-11 00:02
 **/
public class TwoZero {
    public boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sArray) {
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
            } else if (')' == c) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if ('}' == c) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
