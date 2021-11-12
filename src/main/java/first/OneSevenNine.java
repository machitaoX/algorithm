package first;

import java.util.PriorityQueue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-12 00:02
 **/
public class OneSevenNine {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x,y) -> (y + x).compareTo(x + y));
        for (int x : nums) {
            heap.offer(String.valueOf(x));
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (heap.size() > 0) {
            stringBuffer.append(heap.poll());
        }
        return stringBuffer.charAt(0) == '0' ? "0" : stringBuffer.toString();
    }
}
