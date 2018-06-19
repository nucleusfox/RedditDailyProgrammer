/******************************************************************************
 *  Class: E364
 *  Author: nucleusfox
 *
 *  Dice Roller
 *  Accepts lines with roll request in form of "NdM" where the N is number of
 *  rolls and M is number of dice's sides. Prints the sum of N random rolls of
 *  M-sides dice.
 *
 *
 *  Reddit DailyProgrammer - #364 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8s0cy1/20180618_challenge_364_easy_create_a_dice_roller/
 *
 *  Example:
 *  $ java E364
 *  3d6
 *
 *  Result:
 *  15
 *
 *  $ java E364
 *  4d12
 *
 *  Possible result:
 *  29
 ******************************************************************************/

import java.util.Scanner;

public class E364 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String request = sc.nextLine();

        while(!request.isEmpty()) {
            String[] NM = request.split("d");

            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            int sum = 0;
            for (int i = 0; i < N; i++)
                sum += 1 + (int) (Math.random() * M);
            System.out.println(sum);
            request = sc.nextLine();
        }
    }
}
