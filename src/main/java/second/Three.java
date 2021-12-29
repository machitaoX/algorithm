package second;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 10:53
 **/
public class Three {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        int temp = 0;
        while (end <= s.length()) {
            if (map.containsKey(s.charAt(end))) {
                int newStart = map.get(s.charAt(end)) + 1;
                while (start != newStart) {
                    map.remove(s.charAt(start));
                    start++;
                }
                max = Math.max(max, temp);
                temp = end - start;
            }
            map.put(s.charAt(end), end);
            temp++;
            end++;
        }
        return Math.max(max, temp);
    }
}
