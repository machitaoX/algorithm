package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-16 22:04
 **/
public class OneEightSix {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        revert(s, 0, s.length - 1);
        int moveStart = 0, moveEnd = 1;
        while (moveEnd < s.length) {
            if (' ' == s[moveEnd]) {
                revert(s, moveStart, moveEnd - 1);
                moveEnd++;
                moveStart = moveEnd;
            }
            moveEnd++;
        }
        revert(s, moveStart, moveEnd - 1);
    }

    private void revert(char[] s, int start, int end) {
        int moveStart = start;
        int moveEnd = end;
        while (moveStart < moveEnd) {
            char temp = s[moveStart];
            s[moveStart] = s[moveEnd];
            s[moveEnd] = temp;
            moveStart++;
            moveEnd--;
        }
    }
}
