package first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author machitao
 * @date 2021/11/17
 * @description
 */
public class OneEightSeven {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String key = s.substring(i - 10, i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
