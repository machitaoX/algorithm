package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-08-26 22:16
 **/
public class Three {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int start = 0;
        int end = 1;
        int maxLength = 1;
        while (end < length) {
            char readyToMatch = s.charAt(end);
            for (int i = start; i < end; i++) {
                char c = s.charAt(i);
                if (readyToMatch == c) {
                    maxLength = Math.max(maxLength, end - start);
                    start = i + 1;
                    break;
                }
            }
            end++;
        }
        maxLength = Math.max(maxLength, end - start);
        return maxLength;
    }
}
