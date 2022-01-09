package first;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 11:18
 **/
public class ThreeFourNine {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int k : nums1) {
            set1.add(k);
        }
        for (int k : nums2) {
            if (set1.contains(k)) {
                set2.add(k);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (int k : set2) {
            res[i] = k;
        }
        return res;
    }
}
