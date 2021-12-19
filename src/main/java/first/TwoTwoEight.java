package first;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-19 15:19
 **/
public class TwoTwoEight {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int length = nums.length;
        Integer pre = null;
        Integer after = null;
        for (int i = 0; i < length; i++) {
            pre = nums[i];
            while (i + 1 < length && nums[i + 1] == nums[i] + 1) {
                after = nums[i + 1];
                i++;
            }
            if (after != null) {
                res.add((new StringBuilder()).append(pre).append("->").append(after).toString());
                after = null;
            } else {
                res.add(String.valueOf(pre));
            }
        }
        return res;
    }
}
