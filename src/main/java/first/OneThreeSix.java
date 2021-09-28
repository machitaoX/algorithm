package first;

/**
 * @author machitao
 * @date 2021/9/28
 * @description
 */
public class OneThreeSix {
    public int singleNumber(int[] nums) {
        int calculate = 0;
        for (int num : nums){
            calculate ^= num;
        }
        return calculate;
    }
}
