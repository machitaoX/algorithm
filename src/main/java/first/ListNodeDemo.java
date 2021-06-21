package first;

/**
 * @author machitao
 * @date 2021/6/21
 * @description
 */
public class ListNodeDemo {
    int val;
    ListNodeDemo next;
    ListNodeDemo(){}
    ListNodeDemo(int val) { this.val = val; }
    ListNodeDemo(int val, ListNodeDemo next) { this.val = val; this.next = next; }
}
