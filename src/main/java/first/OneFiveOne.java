package first;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-21 22:08
 **/
public class OneFiveOne {
    public String reverseWords(String s) {
        int fast = 1, slow = 0, n = s.length();
        List<String> stringList = new ArrayList<>();
        while (fast < n && slow < n) {
            if (s.charAt(slow) == ' ') {
                slow++;
                fast = slow + 1;
                continue;
            }
            if (s.charAt(fast) == ' ') {
                stringList.add(s.substring(slow,fast));
                slow = fast + 1;
                fast = slow + 1;
                continue;
            }
            if (fast == n - 1) {
                stringList.add(s.substring(slow,fast));
            }
            fast++;
        }
        if (slow == n - 1 && fast == n && !" ".equals(s.substring(slow,fast))) {
            stringList.add(s.substring(slow,fast));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringList.stream()
                .limit(stringList.size() - 1)
                .forEach(
                        string -> stringBuffer.insert(0, " " + string)
                );
        stringBuffer.insert(0, stringList.get(stringList.size() - 1));
        return stringBuffer.toString();
    }
}
