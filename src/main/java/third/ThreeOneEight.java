package third;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2023-02-14 21:22
 **/
public class ThreeOneEight {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });
        int left = 0, right = 1, max = 0;
        while (true) {
            if (left == words.length - 1) {
                break;
            } else if (right == words.length) {
                left++;
                right = left + 1;
            } else {
                if (strDiff(words[left], words[right])) {
                    max = Math.max(words[left].length() * words[right].length(), max);
                    left++;
                    right = left + 1;
                } else {
                    right++;
                }
            }
        }
        return max;
    }

    private boolean strDiff(String str1, String str2) {
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        for (int i = 0; i < str1Array.length; i++) {
            for (int j = 0; j < str2Array.length; j++) {
                if (str1Array[i] == str2Array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
