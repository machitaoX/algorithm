package forth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 500
 * @author: machitao
 * @create: 2023-05-08 22:31
 **/
public class FiveZeroZero {
    public static final Map<Character, Integer> MAP = new HashMap<>();
    static {
        String lineOne = "qwertyuiop";
        char[] lineOneArray = lineOne.toCharArray();
        for (char one : lineOneArray) {
            MAP.put(one, 1);
        }

        String lineTwo = "asdfghjkl";
        char[] lineTwoArray = lineTwo.toCharArray();
        for (char one : lineTwoArray) {
            MAP.put(one, 2);
        }

        String lineThree = "zxcvbnm";
        char[] lineThreeArray = lineThree.toCharArray();
        for (char one : lineThreeArray) {
            MAP.put(one, 3);
        }
    }
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            char[] chars = word.toCharArray();
            int first = MAP.get(chars[0]);
            int count = 0;
            for (char sp : chars) {
                Integer integer = MAP.get(sp);
                if (integer != first) {
                    break;
                }
                count++;
            }
            if (count == chars.length) {
                res.add(words[i]);
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        FiveZeroZero fiveZeroZero = new FiveZeroZero();
        fiveZeroZero.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
    }
}
