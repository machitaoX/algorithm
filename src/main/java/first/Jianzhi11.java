package first;

/**
 * @program: algorithm
 * @description:
 * @author: machitao
 * @create: 2022-01-08 17:56
 **/
public class Jianzhi11 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int medium = low + (high - low) / 2;
            if (numbers[medium] < numbers[high]) {
                high = medium;
            } else if (numbers[medium] > numbers[high]) {
                low = medium + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
