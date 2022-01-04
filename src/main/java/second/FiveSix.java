package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/31
 * @description
 */
public class FiveSix {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> tempRes = new ArrayList<>();
        for (int[] i : intervals) {
            if (tempRes.size() == 0) {
                int[] temp = new int[]{i[0], i[1]};
                tempRes.add(temp);
            } else {
                int[] last = tempRes.get(tempRes.size() - 1);
                if (last[1] >= i[0]) {
                    last[1] = Math.max(last[1], i[1]);
                } else {
                    tempRes.add(new int[]{i[0], i[1]});
                }
            }
        }
        return tempRes.toArray(new int[tempRes.size()][]);
    }
}
