package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-08-27 12:15
 **/
public class Five {
    public String longestPalindrome(String s) {
        int length = s.length();
        String maxStr = "";
        for (int i = 0; i < length; i++) {
            maxStr = checkOneCenter(i, s, maxStr);
        }
        for (int i = 0; i < length - 1; i++) {
            maxStr = checkTwoCenter(i, i + 1, s, maxStr);
        }
        return maxStr;
    }

    private String checkOneCenter(int centerIndex, String s, String maxStr) {
        int pLeft = centerIndex - 1;
        int pRight = centerIndex + 1;
        return checkTwoCenter(pLeft, pRight, s, maxStr);
    }

    private String checkTwoCenter(int centerIndexLeft, int centerIndexRight, String s, String maxStr) {
        while (centerIndexLeft >= 0 && centerIndexRight < s.length()) {
            if (s.charAt(centerIndexLeft) == s.charAt(centerIndexRight)) {
                centerIndexLeft--;
                centerIndexRight++;
                continue;
            }
            return getMaxStr(centerIndexLeft, centerIndexRight, s, maxStr);
        }
        return getMaxStr(centerIndexLeft, centerIndexRight, s, maxStr);
    }

    private String getMaxStr(int centerIndexLeft, int centerIndexRight, String s, String maxStr) {
        if (centerIndexRight - centerIndexLeft - 1 > maxStr.length()) {
            return s.substring(centerIndexLeft + 1, centerIndexRight);
        } else {
            return maxStr;
        }
    }

}
