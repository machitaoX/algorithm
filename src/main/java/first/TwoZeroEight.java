package first;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author machitao
 * @date 2021/12/5
 * @description
 */
public class TwoZeroEight {

    class Trie {
        Set<String> items;

        private Trie() {
            items = new HashSet<>();
        }

        public void insert(String word) {
            if (!items.contains(word)) {
                items.add(word);
            }
        }

        public boolean search(String word) {
            return items.contains(word);
        }

        public boolean startsWith(String prefix) {
            Iterator iterator = items.iterator();
            for (String s : items) {
                if (s.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }
}
