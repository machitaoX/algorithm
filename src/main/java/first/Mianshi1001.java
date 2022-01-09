package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-09 16:29
 **/
public class Mianshi1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = m - 1; i >= 0; i--) {
            A[A.length - m + i] = A[i];
        }
        int move = 0;
        int moveA = A.length - m, moveB = 0;
        while (moveA != A.length && moveB != B.length) {
            if (A[moveA] > B[moveB]) {
                A[move] = B[moveB];
                move++;
                moveB++;
            } else {
                A[move] = A[moveA];
                move++;
                moveA++;
            }
        }
        if (moveB != B.length) {
            for (; moveB < B.length; moveB++) {
                A[move] = B[moveB];
                move++;
            }
        }
    }
}
