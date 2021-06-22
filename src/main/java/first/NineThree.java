package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machitao
 * @date 2021/6/22
 * @description
 */
public class NineThree {
    /**
     * ip地址分为四段
     */
    static final int SEG_COUNT = 4;

    /**
     * 结果集
     */
    List<String> res = new ArrayList<String>();

    /**
     * ip
     */
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {

        // 先排除长度不符合规范的
        if (s.length() < 4 || s.length() > 12){
            return res;
        }
        segments = new int[SEG_COUNT];
        dfs(s,0,0);
        return res;
    }

    private void dfs(String s, int segId, int segStart){
        // 1、如果找到了第四段ip地址
        if (segId == SEG_COUNT){
            // 并且遍历完了字符串
            if (segStart == s.length()){
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++){
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT-1){
                        ipAddr.append(".");
                    }
                }
                res.add(ipAddr.toString());
            }
            return;
        }

        // 2、如果还没有找到第四段，s字符串就已经遍历完毕，提前回溯
        if (segStart == s.length()){
            return;
        }

        // 3、没有找到第四段，且s字符没有遍历完毕
        //      1、由于不能有前导零，如果当前数字为0，那么这一段ip也只能为0
        //      2、是正常数字

        // 由于不能有前导零，如果当前数字为0，那么这一段ip也只能为0
        if (s.charAt(segStart) == '0'){
            segments[segId] = 0;
            dfs(s,segId+1,segStart+1);
        }

        // 是正常数字
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++){
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            // 单独为0的情况在这里就可以排除
            if (addr > 0 && addr <= 0xff){
                segments[segId] = addr;
                dfs(s,segId+1,segEnd+1);
            } else {
                // 当前ip部分不正确的话，后边的ip都不符合条件了
                break;
            }
        }

    }
}
