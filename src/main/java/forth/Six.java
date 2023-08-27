package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-08-27 21:25
 **/
public class Six {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int moveIndex = i;
            int stepFirst = 2 * (numRows - 1 - i);
            int stepSecond = 2 * i;
            int step = stepFirst;
            while (moveIndex < length) {
                sb.append(s.charAt(moveIndex));
                if (i == numRows - 1 || (step == stepFirst && stepSecond != 0)) {
                    step = stepSecond;
                } else {
                    step = stepFirst;
                }
                moveIndex = moveIndex + step;
            }
        }
        return sb.toString();
    }
}
