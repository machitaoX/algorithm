package third;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author machitao
 * @date 2022/10/12
 * @description
 */
public class Three {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> positionMap = new HashMap<>();
        int p1 = 0, p2 = 1;
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length = s.length(), maxLength = 1;
        positionMap.put(s.charAt(0), 0);
        while (p2 < length) {
            if (positionMap.get(s.charAt(p2)) == null) {
                positionMap.put(s.charAt(p2), p2);
                p2++;
            } else {
                maxLength = Math.max(maxLength, p2 - p1);
                int tempPosition = positionMap.get(s.charAt(p2));
                while (p1 <= tempPosition) {
                    positionMap.remove(s.charAt(p1));
                    p1++;
                }
                positionMap.put(s.charAt(p2), p2);
                p2++;
            }
        }
        maxLength = Math.max(maxLength, p2 - p1);
        return maxLength;
    }

    public int lengthOfLongestSubstringV2(String s) {
        int[] positionArray = new int[128];
        Arrays.fill(positionArray, -1);
        int start = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            int position = s.charAt(i);
            start = Math.max(start, positionArray[position] + 1);
            res = Math.max(res, i - start + 1);
            positionArray[position] = i;
        }
        return res;

    }
}
