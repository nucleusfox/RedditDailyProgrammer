/******************************************************************************
 *  Class: E359
 *  Author: nucleusfox
 *
 *  Dragon Curve
 *  Accepts a number N and prints the generated dragon curve sequence
 *  (regular paperfold sequence) up to Nth generation.
 *
 *
 *  Reddit DailyProgrammer - #359 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8g0iil/20180430_challenge_359_easy_regular_paperfold/
 *
 *  Example:
 *  $ java E359
 *  4
 *
 *  Result:
 *  1
 *  110
 *  1101100
 *  110110011100100
 ******************************************************************************/
import java.util.Arrays;
import java.util.Scanner;

public class E359 {
    public static short[] bend(short[] bender) {
        short[] auxiliary = Arrays.copyOf(bender, 2*bender.length+1);
        auxiliary[bender.length] = 1;

        for (int i = 0; i < bender.length; i++)
            auxiliary[bender.length + i + 1] = (short) (bender[bender.length - 1 - i] == (short)1 ? 0 : 1);

        return auxiliary;
    }

    public static String getSequenceString(int generation) {
        StringBuilder sb = new StringBuilder();
        short[] bender = new short[1];
        bender[0] = 1;

        for (int i = 0; i < generation-1; i++) {
            bender = bend(bender);
        }

        for (short b : bender) sb.append(b);
        return sb.toString();
    }

    public static short[] getSequence(int generation) {
        StringBuilder sb = new StringBuilder();
        short[] bender = new short[1];
        bender[0] = 1;

        for (int i = 0; i < generation-1; i++) {
            bender = bend(bender);
        }

        return bender;
    }

    public static void printSequence(short[] bender) {
        for (short b : bender)
            System.out.print(b);
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        short[] bender = new short[1];
        bender[0] = 1;
        printSequence(bender);

        for (int i = 0; i < N-1; i++) {
            bender = bend(bender);
            printSequence(bender);
        }

        //System.out.println("Check sequence: " + getSequence(N));
    }
}
