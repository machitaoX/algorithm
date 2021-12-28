package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-27 21:30
 **/
public class Six {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuffer> strList = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            strList.add(new StringBuffer());
        }
        boolean turnHead = false;
        int moveNumRows = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuffer stringBuffer = strList.get(moveNumRows);
            stringBuffer.append(s.charAt(i));
            if (moveNumRows == 0 || moveNumRows == numRows - 1) {
                turnHead = !turnHead;
            }
            moveNumRows += turnHead ? 1 : -1;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer stringBuffer : strList) {
            res.append(stringBuffer);
        }
        return res.toString();
    }
}
