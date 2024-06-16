package forth;

/**
 * @program: algorithm
 * @description: 14
 * @author: machitao
 * @create: 2024-06-16 00:12
 **/
public class OneFour {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length ==0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String minLengthStr = strs[0];
        int minLength = strs[0].length();
        for (String str : strs) {
            if (str.length() < minLength) {
                minLengthStr = str;
                minLength = str.length();
            }
        }
        if (minLengthStr.length() == 0) {
            return minLengthStr;
        }
        for (String str : strs) {
            minLengthStr = findCommonStr(minLengthStr, str);
            if (minLengthStr.length() == 0) {
                return minLengthStr;
            }
        }
        return minLengthStr;
    }

    private String findCommonStr(String tempMinStr, String str) {
        int minLength = tempMinStr.length();
        for (int i = 0; i < minLength; i++) {
            if (tempMinStr.charAt(i) != str.charAt(i)) {
                return tempMinStr.substring(0, i);
            }
        }
        return tempMinStr;
    }
}
