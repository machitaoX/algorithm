package forth;

import java.util.Random;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-05-12 21:09
 **/
public class FourNineSeven {

    int[][] rects;
    int[] area;

    public FourNineSeven(int[][] rects) {
        this.rects = rects;
        int n = rects.length;
        area = new int[n];
        for (int i = 0; i < n; i++) {
            int[] rect = rects[i];
            int length = rect[0] - rect[2];
            int width = rect[1] - rect[3];
            int areaTemp = length * width;
            area[i] = areaTemp;
        }
    }

    // 每个模块算面积
    // 维护一个队列，累加的面积
    // 随机在0-max抽取一个数字，查询到对应的面积，在对应的面积中取出坐标
    // 计算第几个点
    public int[] pick() {
        int n = rects.length;
        int maxArea = area[n - 1];
        Random r =  new Random();
        int randomNum = r.nextInt(maxArea + 1);
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (randomNum <= area[i]) {
                index = i;
                break;
            }
        }
        if (index != 0) {
            randomNum = randomNum - area[index - 1];
        }
        int length = rects[index][0] - rects[index][2];
        int lengthIndex = randomNum / length;
        int widthIndex = randomNum % length;
        return new int[]{lengthIndex, widthIndex};
    }
}
