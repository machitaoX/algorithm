package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-06 21:50
 **/
public class ThreeNineTwo {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        int sPtr = 0, tPtr = 0;
        while (sPtr < s.length() && tPtr < t.length()) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) {
                sPtr++;
            }
            tPtr++;
        }
        return sPtr == s.length();
    }
}
