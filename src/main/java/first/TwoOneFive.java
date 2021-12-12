package first;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author machitao
 * @date 2021/12/10
 * @description
 */
public class TwoOneFive {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        for (int i = 0; i < nums.length - 1; i++) {
            priorityQueue.offer(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }
}
