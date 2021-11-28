package first;

import java.util.HashMap;

/**
 * @author machitao
 * @date 2021/11/28
 * @description
 */
public class TwoZeroFive {
    public boolean isIsomorphic(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
