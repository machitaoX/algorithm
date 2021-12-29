package second;

/**
 * @author machitao
 * @date 2021/12/29
 * @description
 */
public class OneTwoOne {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] minPrice = new int[length];
        minPrice[0] = prices[0];
        int max = 0;
        for (int i = 1; i < length; i++) {
            max = Math.max(max, prices[i] - minPrice[i - 1]);
            minPrice[i] = Math.min(minPrice[i - 1], prices[i]);
        }
        return max;
    }
}
