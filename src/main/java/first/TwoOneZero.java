package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/5
 * @description
 */
public class TwoOneZero {
    List<List<Integer>> gate;
    int[] route;
    boolean vaild = true;
    int[] res;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        gate = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            gate.add(new ArrayList<>());
        }
        route = new int[numCourses];
        res = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            gate.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && vaild; i++) {
            if (route[i] == 0) {
                dfs(i);
            }
        }
        return vaild ? res : new int[0];
    }

    private void dfs(int u) {
        route[u] = 1;
        for (int v : gate.get(u)) {
            if (route[v] == 0) {
                dfs(v);
                if (!vaild) {
                    return;
                }
            } else if (route[v] == 1) {
                vaild = false;
                return;
            }
        }
        route[u] = 2;
        res[index--] = u;
    }
}
