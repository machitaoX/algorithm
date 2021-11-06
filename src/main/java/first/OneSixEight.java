package first;

/**
 * @author machitao
 * @date 2021/11/6
 * @description
 */
public class OneSixEight {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int temp = (columnNumber - 1) % 26 + 1;
            sb.append((char)(temp - 1 + 'A'));
            columnNumber = (columnNumber - temp) / 26;
        }
        return sb.reverse().toString();
    }
}
