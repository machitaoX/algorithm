package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-07 18:23
 **/
public class FiveFiveSeven {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = i - 1; p >= start; p--) {
                sb.append(s.charAt(p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
