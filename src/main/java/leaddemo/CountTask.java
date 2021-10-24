package leaddemo;

import java.util.concurrent.RecursiveTask;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-10-24 16:45
 **/
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }
        return null;
    }
}
