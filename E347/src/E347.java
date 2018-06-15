/******************************************************************************
 *  Class: E347
 *  Author: nucleusfox
 *
 *  Accepts pairs of numbers reflecting periods (occupation hours, exclusively
 *  for the second number) and prints the addition of those periods.
 *
 *  Reddit DailyProgrammer - #347 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/7qn07r/20180115_challenge_347_easy_how_long_has_the/
 *
 *  Example:
 *  $ java E347
 *  1 3
 *  2 3
 *  4 5
 *
 *  Result:
 *  3
 ******************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

public class E347 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        int[] count = new int[20];
        Arrays.fill(count, 0);

        while (!line.isEmpty()) {
            String[] numbers = line.split("\\s+");
            int start = Integer.valueOf(numbers[0]);
            int end = Integer.valueOf(numbers[1]);

            for (int i = start; i < end; i++)
                count[i]=1;

            line = s.nextLine();
        }

        //System.out.print(Arrays.toString(count));

        int sum = 0;
        for (int i = 0; i < 10; i++) sum+=count[i];

        System.out.println(sum);
    }
}
