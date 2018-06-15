/******************************************************************************
 *  Class: E361
 *  Author: nucleusfox
 *
 *  Tally Program
 *  Accepts the line of characters that indicates wins and loses of 5 players:
 *  a, b, c, d and e.
 *  Prints the scores for each player.
 *
 *  Reddit DailyProgrammer - #361 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8jcffg/20180514_challenge_361_easy_tally_program/
 *
 *  Example:
 *  $ java E361
 *  dbbaCEDbdAacCEAadcB
 *
 *  Result:
 *  a: 1, b: 2, c: 0, d 2, e -2
 ******************************************************************************/

import java.util.Scanner;

public class E361 {
    public static void main(String[] args) {
        int[] score = new int[5];
        Scanner s = new Scanner(System.in);

        String line = s.nextLine();
        for (int i = 0; i < line.length(); i++)
            switch (line.charAt(i)) {
                case 'a' : score[0]++; break;
                case 'A' : score[0]--; break;
                case 'b' : score[1]++; break;
                case 'B' : score[1]--; break;
                case 'c' : score[2]++; break;
                case 'C' : score[2]--; break;
                case 'd' : score[3]++; break;
                case 'D' : score[3]--; break;
                case 'e' : score[4]++; break;
                case 'E' : score[4]--; break;
            }

        System.out.println("a: " + score[0] + ", b: " + score[1] + ", c: " + score[2] + ", d " + score[3] + ", e " + score[4]);
    }
}
