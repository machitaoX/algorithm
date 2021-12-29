package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 11:13
 **/
public class Five {
    public String longestPalindrome(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int maxLength = 1;
        for (int i = 0; i < length; i++) {
            // 中心对称
            if (i > 0 && i < length - 1) {
                StringBuilder tempSb = new StringBuilder();
                tempSb.append(s.charAt(i));
                int leftMove = i - 1;
                int rightMove = i + 1;
                while (leftMove >= 0 && rightMove < length) {
                    if (s.charAt(leftMove) != s.charAt(rightMove)) {
                        int tempLength = rightMove - leftMove - 1;
                        if (maxLength < tempLength) {
                            maxLength = tempLength;
                            sb = tempSb;
                        }
                        break;
                    }
                    tempSb.insert(0, s.charAt(leftMove));
                    tempSb.append(s.charAt(rightMove));
                    leftMove--;
                    rightMove++;
                }
                int tempLength = rightMove - leftMove - 1;
                if (maxLength < tempLength) {
                    maxLength = tempLength;
                    sb = tempSb;
                }
            }
            // 轴对称
            if (i < length - 1) {
                StringBuilder tempSb2 = new StringBuilder();
                int leftMove = i;
                int rightMove = i + 1;
                while (leftMove >= 0 && rightMove < length) {
                    if (s.charAt(leftMove) != s.charAt(rightMove)) {
                        int tempLength = rightMove - leftMove - 1;
                        if (maxLength < tempLength) {
                            maxLength = tempLength;
                            sb = tempSb2;
                        }
                        break;
                    }
                    tempSb2.insert(0, s.charAt(leftMove));
                    tempSb2.append(s.charAt(rightMove));
                    leftMove--;
                    rightMove++;
                }
                int tempLength = rightMove - leftMove - 1;
                if (maxLength < tempLength) {
                    maxLength = tempLength;
                    sb = tempSb2;
                }
            }
        }
        return sb.toString();
    }
}
