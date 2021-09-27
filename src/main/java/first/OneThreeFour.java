package first;

/**
 * @author machitao
 * @date 2021/9/27
 * @description
 */
public class OneThreeFour {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int addAll = 0, costAll = 0;
        int[] left = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            addAll = gas[i] + addAll;
            costAll = cost[i] + costAll;
            left[i] = gas[i] - cost[i];
        }

        if (addAll < costAll) {
            return -1;
        }
        for (int i = 0; i < left.length; i++) {
            if (check(left, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(int[] left, int i) {
        int sum = 0;
        for (int start = i; start < left.length; i++) {
            sum = sum + left[start];
            if (sum < 0) {
                return false;
            }
        }
        return true;
    }
}
