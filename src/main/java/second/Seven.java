package second;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-12-29 12:31
 **/
public class Seven {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int k = x;
        // 去掉尾巴上的0
        while (k % 10 == 0) {
            k = k / 10;
        }
        String xStr = String.valueOf(x);
        boolean nigative = false;
        if (xStr.startsWith("-")) {
            nigative = true;
            xStr = xStr.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = xStr.length() - 1; i >= 0; i--) {
            sb.append(xStr.charAt(i));
        }
        if (nigative) {
            sb.insert(0, "-");
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
