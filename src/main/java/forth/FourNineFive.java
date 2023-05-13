package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-05-13 17:06
 **/
public class FourNineFive {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int result = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            result = result + Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return result;
    }
}
