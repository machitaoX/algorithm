package second;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-07-07 23:23
 **/
public class SixFourEight {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0) {
            return sentence;
        }
        dictionary.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            }
            return 0;
        });
        String[] senArray = sentence.split(" ");
        for (int i = 0; i < senArray.length; i++) {
            for (String s : dictionary) {
                if (senArray[i].startsWith(s)) {
                    senArray[i] = s;
                    break;
                }
            }
        }
        return String.join(" ", senArray);
    }
}
