package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 10:28
 **/
public class Jianzhi57 {
    public static void main(String[] args) {
        List<List<Integer>> res = findContinuousSequence(15);
        for (List<Integer> temp : res) {
            System.out.println(temp.toString());
        }
    }
    public static List<List<Integer>> findContinuousSequence(int target) {
        int end = (target + 1) / 2;
        int left = 0, right = 0;
        int tempSum = 0;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        while (left <= right && right <= end) {
            if (tempSum == target) {
                res.add(new ArrayList<>(temp));
                right++;
                tempSum += right;
                temp.add(right);
            } else if (tempSum > target) {
                left++;
                tempSum -= left;
                temp.remove(0);
            } else {
                right++;
                tempSum += right;
                temp.add(right);
            }
        }
        return res;
    }
}
