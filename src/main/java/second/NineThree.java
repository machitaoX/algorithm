package second;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-30 20:29
 **/
public class NineThree {
    List<String> res;
    int[] tempArray;
    int count = 4;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        tempArray = new int[count];
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int arrayIndex, int sIndex) {
        if (arrayIndex == count) {
            if (sIndex == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append(tempArray[i]);
                    if (i != count - 1) {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        if (sIndex == s.length()) {
            return;
        }
        if (s.charAt(sIndex) == 0) {
            tempArray[arrayIndex] = 0;
            dfs(s, arrayIndex + 1, sIndex + 1);
        }
        int addr = 0;
        for (int segEnd = sIndex; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                tempArray[arrayIndex] = addr;
                dfs(s, arrayIndex + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
