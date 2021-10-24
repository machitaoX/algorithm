package first;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-24 17:31
 **/
public class OneFiveNine {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>(3);
        int start = 0, end = 0, max = 0;
        while (end < s.length()) {
            if (hashMap.size() < 3) {
                hashMap.put(s.charAt(end), end++);
            }
            if (hashMap.size() == 3) {
                start = Collections.min(hashMap.values()) + 1;
                hashMap.remove(s.charAt(start - 1));
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
