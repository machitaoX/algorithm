package first;

/**
 * @author machitao
 * @date 2022/2/26
 * @description
 */
public class TwoEightThree {
    public static void moveZeroes(int[] nums) {
        int zeroPtr = -1, notZeroPtr = -1;
        for (int i = 0; i < nums.length; i++) {
            if (zeroPtr == -1 && nums[i] == 0) {
                zeroPtr = i;
            }
            if (zeroPtr != -1 && notZeroPtr == -1 && nums[i] != 0) {
                notZeroPtr = i;
            }
        }
        while (notZeroPtr != -1 && zeroPtr != -1) {
            int temp = nums[zeroPtr];
            nums[zeroPtr] = nums[notZeroPtr];
            nums[notZeroPtr] = temp;
            zeroPtr += 1;
            for (int i = notZeroPtr + 1; i < nums.length + 1; i++) {
                if (i < nums.length && nums[i] != 0) {
                    notZeroPtr = i;
                    break;
                }
                if (i == nums.length) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{45192,0,-659,-52359,-99225,-75991,0,-15155,27382,59818,0,-30645,-17025,81209,887,64648});
    }
}
