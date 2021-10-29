package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-24 23:10
 **/
public class OneSixOne {
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s == null ? 0 : s.length();
        int tLength = t == null ? 0 : t.length();
        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }

        if (sLength < tLength) {
            return isOneEditDistance(t, s);
        }

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLength == tLength) {
                    return s.substring(i + 1, sLength).equals(t.substring(i + 1, sLength));
                }
                return s.substring(i + 1, sLength).equals(t.substring(i, tLength));
            }
        }
        return tLength + 1 == sLength;
    }
}
