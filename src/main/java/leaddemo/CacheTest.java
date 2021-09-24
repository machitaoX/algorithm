package leaddemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * @author machitao
 * @date 2021/9/20
 * @description
 */
public class CacheTest {

    public static void main(String[] args) {
        Cache<String, String> caffeine = Caffeine.newBuilder()
                .initialCapacity(500)
                .maximumSize(600)
                .build();
        caffeine.put("hello", "my");
        String he = caffeine.getIfPresent("hello");
        System.out.println(he);
    }

    private static String getStr(String k) {
        return k + "";
    }
}
