package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author machitao
 * @date 2022/1/5
 * @description
 */
public class TwoSevenFour {
    public int hIndex(int[] citations) {
        int length = citations.length;
        Arrays.sort(citations);
        for (int i = length - 1; i >= 0; i--) {
            if (citations[i] < length - i) {
                return length - i - 1;
            }
        }
        return length;
    }
}
