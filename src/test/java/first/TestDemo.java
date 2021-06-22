package first;

import org.junit.Test;

/**
 * @author machitao
 * @date 2021/6/22
 * @description
 */
public class TestDemo {
    @Test
    public void testNineTwo(){
        NineTwo nineTwo = new NineTwo();
        NineTwo.ListNode head = new NineTwo.ListNode(1);
        NineTwo.ListNode res = nineTwo.reverseBetween(head,2,6);

    }

    @Test
    public void testNineThree(){
        NineThree nineThree = new NineThree();
        System.out.println(nineThree.restoreIpAddresses("25525511135"));

    }
}
