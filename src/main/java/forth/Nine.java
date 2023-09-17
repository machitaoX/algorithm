package forth;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-09-17 22:59
 **/
public class Nine {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        int length = xStr.length();
        int moveLeft = 0;
        int moveRight = length - 1;
        while (moveLeft < moveRight) {
            if (xStr.charAt(moveLeft) != xStr.charAt(moveRight)) {
                return false;
            }
            moveLeft++;
            moveRight--;
        }
        return true;
    }

    public boolean isPalindromeV2(int x) {
        if (x < 0) {
            return false;
        }
        int xRe = 0;
        int xOriginal = x;
        while (x != 0) {
            int left = x % 10;
            x = x / 10;
            xRe = xRe * 10 + left;
        }
        return xOriginal == xRe;
    }
}
