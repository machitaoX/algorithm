package first;

import java.util.Arrays;

/**
 * @author machitao
 * @date 2022/2/20
 * @description
 */
public class TwoNineNine {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int[] markSecret = new int[length];
        int[] markGuess = new int[length];
        Arrays.fill(markSecret, 0);
        Arrays.fill(markGuess, 0);
        int aNum = 0, bNum = 0;
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i) && markGuess[i] == 0) {
                markSecret[i] = 1;
                markGuess[i] = 1;
                aNum++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (markGuess[i] == 0) {
                for (int j = 0; j < length; j++) {
                    if (markSecret[j] == 0 && guess.charAt(i) == secret.charAt(j)) {
                        markGuess[i] = 1;
                        markSecret[j] = 1;
                        bNum++;
                        break;
                    }
                }
            }
        }
        return aNum + "A" + bNum + "B";
    }
}
