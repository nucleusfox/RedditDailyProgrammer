/******************************************************************************
 *  Class: LFSR
 *  Author: nucleusfox
 *
 *  Linear Feedback Shift Register
 *  Accepts a line of
 *
 *  Reddit DailyProgrammer - #347 [Intermediate]
 *  https://www.reddit.com/r/dailyprogrammer/comments/7r17qr/20180117_challenge_347_intermediate_linear/
 *
 *  Example:
 *  $ java LFSR
 *  [0,2] XOR 001 7
 *
 *  Result:
 *  0 001
 *  1 100
 *  2 110
 *  3 111
 *  4 011
 *  5 101
 *  6 010
 *  7 001
 ******************************************************************************/
import java.util.Scanner;

public class LFSR {
    public enum FEEDBACK_OPERATION { XOR, XNOR }

    public static int feedback(int number, int[] feedbackMask, FEEDBACK_OPERATION op) {
        int feedbackBit = 0;
        switch (op) {
            case XOR:
                for (int f : feedbackMask) feedbackBit = feedbackBit ^ Integer.bitCount(number & f);
                break;
            case XNOR:
                feedbackBit = 1;
                for (int f : feedbackMask) feedbackBit = feedbackBit ^ ~(Integer.bitCount( number & f ));
                break;
        }
        return  feedbackBit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] token = input.split("\\s+");

        String[] tapsString = token[0].substring(1, token[0].length() - 1).split(",");
        int[] taps = new int[tapsString.length];
        for(int i = 0; i < tapsString.length; i++)
            taps[i] = Integer.parseInt(tapsString[i]);

        FEEDBACK_OPERATION operation  = FEEDBACK_OPERATION.XOR;;
        if (token[1].equals("XNOR"))
            operation = FEEDBACK_OPERATION.XNOR;
        int cycles = Integer.parseInt(token[3]);

        int number = Integer.parseInt(token[2], 2);
        int length = token[2].length();

        int[] feedbackMask = new int[taps.length];
        for (int i = 0; i < taps.length; i++)
            feedbackMask[i] = 1 << (length - 1 - taps[i]);

        System.out.println(String.format("0 %0" + length + "d", Integer.parseInt(Integer.toBinaryString(number))));
        for (int i = 1; i <= cycles; i++) {
            int feed = feedback(number, feedbackMask, operation);
            number = (number >> 1) | (feed << length - 1);
            System.out.println(String.format(i + " %0" + length + "d", Integer.parseInt(Integer.toBinaryString(number))));
        }
    }
}