package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-07-08 23:16
 **/
public class OneTwoOneSeven {
    public int minCostToMoveChips(int[] position) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < position.length; i++) {
            int sum = 0;
            for (int j = 0; j < position.length; j++) {
                if (i == j) {
                    continue;
                }
                int diff = position[j] - position[i];
                if (diff % 2 != 0) {
                    sum++;
                }
            }
            min = Math.min(sum, min);
        }
        return min;
    }
}
