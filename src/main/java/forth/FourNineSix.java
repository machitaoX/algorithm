package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-05-13 15:40
 **/
public class FourNineSix {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int[] res = new int[length1];
        for (int i = 0; i < length1; i++) {
            int num1 = nums1[i];
            boolean findSame = false;
            boolean findBigger = false;
            for (int j = 0; j < nums2.length; j++) {
                if (findSame) {
                    if (nums2[j] > num1) {
                        findBigger = true;
                        res[i] = nums2[j];
                        break;
                    }
                } else {
                    int num2 = nums2[j];
                    if (num1 == num2) {
                        findSame = true;
                    }
                }
            }
            if (!findBigger) {
                res[i] = -1;
            }
        }
        return res;
    }
}
