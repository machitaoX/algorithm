package first;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-18 16:58
 **/
public class TwoTwoSeven {
    public int calculate(String s) {
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }

        Queue<Integer> num = new LinkedList<>();
        Queue<Character> calculateSignal = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int temp = 0;
                while (Character.isDigit(c)) {
                    temp = temp * 10 + c - '0';
                    i++;
                    if (i >= s.length()) {
                        break;
                    }
                    c = s.charAt(i);
                }
                if (!Character.isDigit(c)) {
                    i--;
                }
                num.offer(temp);
            } else if (' ' == c) {
                // do nothing
            } else {
                calculateSignal.offer(c);
            }
        }
        int res = num.poll();
        while (!calculateSignal.isEmpty()) {
            int first = num.poll();
            char cal = calculateSignal.poll();
            if (cal == '*') {
                res = res * first;
            } else if (cal == '/') {
                res = res / first;
            } else {
                while (!calculateSignal.isEmpty() && calculateSignal.peek() != '+' && calculateSignal.peek() != '-') {
                    char newCal = calculateSignal.poll();
                    int newFirst = num.poll();
                    if (newCal == '*') {
                        first = newFirst * first;
                    } else {
                        first = first / newFirst;
                    }
                }
                if (cal == '+') {
                    res = first + res;
                } else {
                    res = res - first;
                }
            }
        }
        return res;
    }
}
