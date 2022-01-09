package first;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 10:13
 **/
public class Jianzhi40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
