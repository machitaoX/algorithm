package second;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-07-05 22:28
 **/
public class SevenTwoNine {

    class MyCalendar {
        List<int[]> arrayList = new ArrayList<>();
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if (arrayList.size() == 0) {
                int[] temp = new int[2];
                temp[0] = start;
                temp[1] = end;
                return arrayList.add(temp);
            }
            int lastEnd = 1;
            int length = arrayList.size();
            for (int i = 0; i < length; i++) {
                int[] temp = arrayList.get(i);
                if (end < temp[1] && start >= lastEnd) {
                    int[] newTemp = new int[2];
                    newTemp[0] = start;
                    newTemp[1] = end;
                    arrayList.add(i, newTemp);
                    return true;
                }
                if ((temp[0] <= start && start < temp[1]) || (temp[0] <= end && end < temp[1])) {
                    return false;
                }
                if (start < temp[0] && end >= temp[1]) {
                    return false;
                }
                lastEnd = temp[1];
            }
            int[] temp = arrayList.get(arrayList.size() - 1);
            if (temp[1] <= start) {
                int[] newTemp = new int[2];
                newTemp[0] = start;
                newTemp[1] = end;
                arrayList.add(newTemp);
                return true;
            }
            return false;
        }
    }

}
