package first;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author machitao
 * @date 2022/2/22
 * @description
 */
public class TwoNineZero {
    public boolean wordPattern(String pattern, String s) {
        HashSet<String> set = new HashSet<>();
        String[] charArray = new String[26];
        Arrays.fill(charArray, " ");
        String[] strArray= s.split(" ");
        int length = pattern.length();
        if (length != strArray.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int index = pattern.charAt(i) - 'a';
            if (" ".equals(charArray[index])) {
                if (!set.contains(strArray[i])) {
                    set.add(strArray[i]);
                    charArray[index] = strArray[i];
                    continue;
                }
                return false;
            } else {
                if (!strArray[i].equals(charArray[index])) {
                    return false;
                }
            }
        }
        return true;
    }
}
