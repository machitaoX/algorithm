package forth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: algorithm
 * @description: 17
 * @author: machitao
 * @create: 2024-06-19 23:40
 **/
public class OneSeven {
    HashMap<Character, List<String>> digitMap = new HashMap<>() {{
        put('2', List.of("a", "b", "c"));
        put('3', List.of("d", "e", "f"));
        put('4', List.of("g", "h", "i"));
        put('5', List.of("j", "k", "l"));
        put('6', List.of("m", "n", "o"));
        put('7', List.of("p", "q", "r", "s"));
        put('8', List.of("t", "u", "v"));
        put('9', List.of("w", "x", "y", "z"));
    }};
    public List<String> letterCombinations(String digits) {
        return bt(digits.length() - 1, digits);
    }

    private List<String> bt(int index, String digits) {
        if (index == -1) {
            return new ArrayList<>();
        }
        char c = digits.charAt(index);
        List<String> tempBT = bt(index - 1, digits);
        List<String> cha = digitMap.get(c);
        if (tempBT.isEmpty()) {
            return cha;
        }
        List<String> result = new ArrayList<>();
        for (String s : cha) {
            for (String string : tempBT) {
                result.add(string + s);
            }
        }
        return result;
    }
}
