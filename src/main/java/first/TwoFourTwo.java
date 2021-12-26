package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-26 13:53
 **/
public class TwoFourTwo {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a'] -= 1;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
