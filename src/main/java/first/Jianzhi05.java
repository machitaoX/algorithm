package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 17:47
 **/
public class Jianzhi05 {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] temp = new char[length  * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                temp[size++] = '%';
                temp[size++] = '2';
                temp[size++] = '0';
            } else {
                temp[size++] = s.charAt(i);
            }
        }
        return new String(temp, 0, size);
    }
}
