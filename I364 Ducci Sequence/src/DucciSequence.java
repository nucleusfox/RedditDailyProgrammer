/******************************************************************************
 *  Class: DucciSequence
 *  Author: nucleusfox
 *
 *  Ducci Sequence
 *  Accept a string with initial numbers separated by comma. Prints the Ducci sequence
 *  and number of steps before the sequence collapses or went into infinite loop.
 *
 *  Reddit DailyProgrammer - #364 [Intermediate]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8sjcl0/20180620_challenge_364_intermediate_the_ducci/
 *
 *  Example:
 *  $ java DucciSequence
 *  (64, 64, 64, 192)
 *
 *  Result:
 *  [0, 0, 128, 128]
 *  [0, 128, 0, 128]
 *  [128, 128, 128, 128]
 *  [0, 0, 0, 0]
 *  4 steps
 *
 *  Example:
 *  $ java DucciSequence
 *  (0, 3, 4)
 *
 *  Result:
 *  [3, 1, 4]
 *  [2, 3, 1]
 *  [1, 2, 1]
 *  [1, 1, 0]
 *  [0, 1, 1]
 *  [1, 0, 1]
 *  [1, 1, 0]
 *  Infinite loop detected
 *  7 steps
 *
 ******************************************************************************/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DucciSequence {
    public static int[] getDifference(int[] numbers) {
        int[] differences = new int[numbers.length];
        for (int i = 0; i < numbers.length-1; i++)
            differences[i] = Math.abs(numbers[i+1] - numbers[i]);
        differences[numbers.length-1] = Math.abs(numbers[numbers.length-1] - numbers[0]);
        return differences;
    }

    public static boolean isNull(int[] numbers) {
        for (int n : numbers)
            if (n > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] input = line.replaceAll("[()\\s+]", "").split(",");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++)
            numbers[i] = Integer.parseInt(input[i]);

        Set<String> stepCombinations = new HashSet<>();
        stepCombinations.add(Arrays.toString(numbers));

        int steps = 0;
        while (!isNull(numbers)) {
            steps++;
            numbers = getDifference(numbers);
            System.out.println(Arrays.toString(numbers));
            if (stepCombinations.contains(Arrays.toString(numbers))) {
                System.out.println("Infinite loop detected");
                break;
            } else stepCombinations.add(Arrays.toString(numbers));
        }
        System.out.println(steps + " steps");
    }
}
