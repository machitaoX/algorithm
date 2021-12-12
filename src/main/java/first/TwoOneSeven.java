package first;

import java.util.HashSet;

/**
 * @author machitao
 * @date 2021/12/12
 * @description
 */
public class TwoOneSeven {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
