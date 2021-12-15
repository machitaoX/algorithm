package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-15 22:50
 **/
public class TwoTwoThree {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int lengthX1 = ax2 - ax1;
        int lengthX2 = bx2 - bx1;
        boolean mark = false;
        if (Math.max(ax2, bx2) - Math.min(ax1, bx1) >= lengthX1 + lengthX2) {
            mark = true;
        }
        int lengthY1 = ay2 - ay1;
        int lengthY2 = by2 - by1;
        if (Math.max(ay2, by2) - Math.min(ay1, by1) >= lengthY1 + lengthY2) {
            mark = true;
        }
        if (mark) {
            return lengthX1 * lengthY1 + lengthX2 * lengthY2;
        }
        int leftY = Math.min(ay2, by2);
        int leftX = Math.max(ax1, bx1);
        int rightY = Math.max(ay1, by1);
        int rightX = Math.min(ax2, bx2);
        int k = Math.abs(rightX - leftX) * Math.abs(leftY - rightY);
        return lengthX1 * lengthY1 + lengthX2 * lengthY2 - k;
    }
}
