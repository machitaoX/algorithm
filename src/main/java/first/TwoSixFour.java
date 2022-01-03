package first;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-03 16:19
 **/
public class TwoSixFour {
    public int nthUglyNumber(int n) {
        int[] factories = new int[]{1, 2, 3};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(n, Comparator.naturalOrder());
        set.add(1L);
        priorityQueue.offer(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long temp = priorityQueue.poll();
            res = (int)temp;
            for (int factory : factories) {
                long ready = temp * factory;
                if (set.add(ready)) {
                    priorityQueue.offer(ready);
                }
            }
        }
        return res;
    }
}
