/******************************************************************************
 *  Class: E364Bonus
 *  Author: nucleusfox
 *
 *  Dice Roller - Bonus
 *  Accepts lines with roll request in form of "NdM" where the N is number of
 *  rolls and M is number of dice's sides. Prints the sum of N random rolls of
 *  M-sides dice with results of each roll.
 *
 *
 *  Reddit DailyProgrammer - #364 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8s0cy1/20180618_challenge_364_easy_create_a_dice_roller/
 *
 *  Example:
 *  $ java E364
 *  3d6
 *
 *  Possible result:
 *  4: 1 1 2
 *
 *  $ java E364
 *  2d12
 *
 *  Possible result:
 *  17: 11 6
 ******************************************************************************/

import java.util.Scanner;

public class E364Bonus {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String request = sc.nextLine();

        while(!request.isEmpty()) {
            String[] NM = request.split("d");

            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int[] r = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                r[i] = 1 + (int) (Math.random() * M);
                sum += r[i];
            }

            System.out.print(sum + ": ");
            for (int i : r) System.out.print(i + " ");
            System.out.println();
            request = sc.nextLine();
        }
    }
}
