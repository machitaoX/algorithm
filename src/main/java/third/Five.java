package third;

import org.junit.jupiter.api.Test;

/**
 * @author machitao
 * @date 2022/10/13
 * @description
 */
public class Five {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int maxLength = 1;
        String result = s.substring(0, 1);
        for (int left = 0; left < s.length() - 1; left++) {
            // 单中心
            int leftMove = left - 1, rightMove = left + 1, tempLength = 1;
            while (leftMove >= 0 && rightMove < s.length() && s.charAt(leftMove) == s.charAt(rightMove)) {
                tempLength += 2;
                leftMove--;
                rightMove++;
            }

            if (maxLength < tempLength) {
                result = s.substring(leftMove + 1, rightMove);
                maxLength = tempLength;
            }

            // 双中心
            leftMove = left - 1;
            int right = left + 1;
            rightMove = left + 2;
            if (right < s.length() && s.charAt(left) == s.charAt(right)) {
                tempLength = 2;
                while (leftMove >= 0 && rightMove < s.length() && s.charAt(leftMove) == s.charAt(rightMove)) {
                    tempLength += 2;
                    leftMove--;
                    rightMove++;
                }
                if (maxLength < tempLength) {
                    result = s.substring(leftMove + 1, rightMove);
                    maxLength = tempLength;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
    }
}
