package first;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author machitao
 * @date 2021/11/7
 * @description
 */
public class OneSixNine {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.getOrDefault(nums[i], 0) > n) {
                return i;
            }
        }
        return -1;
    }
}
