/******************************************************************************
 *  Class: KolakoskiSequence
 *  Author: nucleusfox
 *
 *  The Kolakoski Sequence
 *  Accepts number N and prints the ratio of 1s and 2s among first N symbols of
 *  Kolakoski sequence.
 *
 *  Reddit DailyProgrammer - #357 [Intermediate]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8df7sm/20180419_challenge_357_intermediate_kolakoski/
 *
 *  Example:
 *  $ java KolakoskiSequence
 *  10
 *
 *  Result:
 *  Time taken: 0ms
 *  5:5
 *
 *  $ java KolakoskiSequence
 *  10
 *
 *  Result:
 *  Time taken: 1ms
 *  49:51
 ******************************************************************************/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KolakoskiSequence {
    private Queue<Integer> sequence = new LinkedList<>();
    private boolean odd = true;
    private long generation = 0;
    private long ones = 0;
    private long twos = 0;
    private long symbols = 0;

    KolakoskiSequence() {
        sequence.add(2);
    }

    private void iterateByGeneration(long end) {
        if (end < 1) return;
        if (generation < end) {
//            System.out.print("1");
            ones++;

            generation++;
        }
        if (end == 1) return;

        if (generation < end) {
//            System.out.print("22");
            twos += 2;
            generation++;
        }
        if (end == 2) return;

        for (; generation < end; generation++) {
            Integer i = sequence.remove();
            for (int j = 0; j < i; j++) {
                if (odd) {
                    sequence.add(1);
//                    System.out.print(1);
                    ones++;
                } else {
                    sequence.add(2);
//                    System.out.print(2);
                    twos++;
                }
            }
            odd = odd ? false : true;
        }
        System.out.println();
    }

    private void iterateBySymbol(long end) {
        if (end < 1) return;
        if (symbols < end) {
//            System.out.print("1");
            ones++;
            symbols++;
        }
        if (end == 1) return;

        if (symbols < end) {
//            System.out.print("22");
            twos += 2;
            symbols += 2;
        }
        if (end == 2) return;
        Integer i;

        while(symbols < end) {
            i = sequence.remove();
            for (int j = 0; j < i; j++) {
                if (odd) {
                    sequence.add(1);
//                    System.out.print(1);
                    ones++;
                    symbols++;
                } else {
                    sequence.add(2);
//                    System.out.print(2);
                    twos++;
                    symbols++;
                }
                if(symbols == end) break;
            }
            odd = odd ? false : true;
        }
//        System.out.println();
    }

    private void printRatio() {
        System.out.print(ones + ":" + twos);
    }

    public static void main(String[] args) {
        KolakoskiSequence ks = new KolakoskiSequence();

        long end = new Scanner(System.in).nextLong();
        long now = System.currentTimeMillis();
        ks.iterateBySymbol(end);
        System.out.println("Time taken: "+(System.currentTimeMillis()-now)+"ms");
        ks.printRatio();
    }
}
