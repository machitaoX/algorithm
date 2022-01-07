package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-07 11:49
 **/
public class SixEightZero {
    public boolean validPalindrome(String s) {
        return check(s, true);
    }

    private boolean check(String s, boolean allowDfs) {
        int left = 0, end = s.length() - 1;
        while (left < end) {
            if (s.charAt(left) != s.charAt(end)) {
                if (allowDfs) {
                    return check(s.substring(left + 1, end + 1), false) || check(s.substring(left, end), false);
                }
                return false;
            }
            left++;
            end--;
        }
        return true;
    }
}
