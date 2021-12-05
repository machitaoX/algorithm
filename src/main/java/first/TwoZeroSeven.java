package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/12/5
 * @description
 */
public class TwoZeroSeven {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int i : edges.get(u)) {
            if (visited[i] == 0) {
                dfs(i);
                if (!valid) {
                    return;
                }
            } else if (visited[i] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
