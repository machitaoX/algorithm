package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-07 17:41
 **/
public class Mianshi0101 {
    public boolean isUnique(String astr) {
        int[] temp = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if (temp[index] != 0) {
                return false;
            }
            temp[index] += 1;
        }
        return true;
    }
}
