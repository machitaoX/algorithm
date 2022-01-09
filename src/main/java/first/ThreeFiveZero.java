package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 20:48
 **/
public class ThreeFiveZero {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int move1 = 0, move2 = 0;
        List<Integer> res = new ArrayList<>();
        while (move1 != nums1.length && move2 != nums2.length) {
            if (nums1[move1] == nums2[move2]) {
                res.add(nums1[move1]);
                move1++;
                move2++;
            } else if (nums1[move1] > nums2[move2]) {
                move2++;
            } else {
                move1++;
            }
        }
        int[] realRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            realRes[i] = res.get(i);
        }
        return realRes;
    }
}
