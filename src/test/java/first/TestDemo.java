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

    }

    @Test
    public void testNineThree(){
        NineThree nineThree = new NineThree();
        System.out.println(nineThree.restoreIpAddresses("25525511135"));
    }

    @Test
    public void testNineSeven(){
        NineSeven nineSeven = new NineSeven();
        System.out.println(nineSeven.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
