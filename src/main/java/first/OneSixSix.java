package first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2021-11-01 22:32
 **/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }
        StringBuffer buffer = new StringBuffer();
        long newNumerator = numerator;
        long newDenominator = denominator;
        if (newNumerator * newDenominator < 0){
            buffer.append("-");
        }
        newNumerator = Math.abs(newNumerator);
        newDenominator = Math.abs(newDenominator);
        buffer.append(newNumerator/newDenominator);
        if (newNumerator%newDenominator != 0){
            buffer.append(".");
        } else {
            return buffer.toString();
        }

        HashMap<Long,Integer> map = new HashMap<>();
        int curPosition = 0;
        long remain = newNumerator%newDenominator;
        List<Long> pointAfter = new ArrayList<>();
        int beforeCur = -1;
        while (remain != 0){
            remain = remain * 10;
            if (map.containsKey(remain)){
                beforeCur = map.get(remain);
                break;
            }
            pointAfter.add(remain/newDenominator);
            map.put(remain,curPosition);
            remain = remain%newDenominator;
            curPosition++;
        }
        for (int i = 0; i < curPosition; i++){
            if (i == beforeCur){
                buffer.append("(");
            }
            buffer.append(pointAfter.get(i));
        }
        if (beforeCur != -1){
            buffer.append(")");
        }
        return buffer.toString();
    }
}
