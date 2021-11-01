package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-01 22:05
 **/
public class OneSixFive {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int v1Length = v1.length;
        int v2Length = v2.length;

        for (int i = 0; i < v1Length || i < v2Length; i++) {
            int x = 0, y = 0;
            if (i < v1Length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2Length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (y > x) {
                return -1;
            }
        }
        return 0;
    }
}
