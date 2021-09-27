package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/9/25
 * @description
 */
public class OneThreeThree {
    public Node cloneGraph(Node node) {
        return null;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
