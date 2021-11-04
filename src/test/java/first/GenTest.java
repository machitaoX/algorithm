package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-01 22:44
 **/
public class GenTest {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        List<String> b = new ArrayList<String>();
        System.out.println(b.getClass() == a.getClass());
    }
}
