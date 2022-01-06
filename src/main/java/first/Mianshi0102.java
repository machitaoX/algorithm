package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-06 19:34
 **/
public class Mianshi0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a'] += 1;
            count[s2.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
