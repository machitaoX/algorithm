package leaddemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author machitao
 * @date 2021/11/17
 * @description
 */
public class ThreadLocalDemo {
    private static final int HASH_INCREMENT = 0x61c88647;
    public static final ThreadLocal<Integer> AGE = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return super.initialValue();
        }
    };


    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        int length = 32;
        for (int i = 0; i < 30; ++i) {
            int hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int location = hashCode & (length - 1);
            res.add(location);
            System.out.println(location);
        }
        System.out.println("=============================");
        res = res.stream().sorted().collect(Collectors.toList());
        for (Integer i : res) {
            System.out.println(i);
        }

    }
}
