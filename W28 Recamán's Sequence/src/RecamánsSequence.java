/******************************************************************************
 *  Class: RecamánsSequence
 *  Author: nucleusfox
 *
 *  Recamán's Sequence
 *  Accepts integer number N. Prints the the Nth element of Recamán's sequence.
 *
 *  https://oeis.org/A005132
 *  Recamán's sequence (Formerly M2511):
 *  a(0) = 0;
 *  for n > 0, a(n) = a(n-1) - n if positive and not already in the sequence,
 *  otherwise a(n) = a(n-1) + n.
 *
 *  First elements of the sequence:
 *  0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8, 25, 43, 62, 42,
 *  63, 41, 18, 42, 17, 43, 16, 44, 15, 45, 14, 46, 79, 113, 78, 114, 77, 39,
 *  78, 38, 79, 37, 80, 36, 81, 35, 82, 34, 83, 33, 84, 32, 85, 31, 86, 30, 87,
 *  29, 88, 28, 89, 27, 90, 26, 91, 157, 224, 156, 225, 155
 *
 *
 *  Reddit DailyProgrammer - Weekly #28 - Mini Challenges
 *  https://www.reddit.com/r/dailyprogrammer/comments/81aexf/weekly_28_mini_challenges/
 *  [nth number of Recamán's Sequence]
 *
 *  Example:
 *  $ java RecamánsSequence
 *  10
 *
 *  Result:
 *  21
 ******************************************************************************/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecamánsSequence {

    public static void main (String[] args) {
        String line = new Scanner(System.in).nextLine();
        int N = Integer.parseInt(line);
        Set<Integer> elements = new HashSet<>();
        int current = 0;
        elements.add(current);

        for (int i = 1; i < N; i++) {
            int possible = 0;
            if (current > i && !elements.contains(current - i))
                possible = current - i;
            else
                possible = current + i;

            current = possible;
            elements.add(possible);
        }

        System.out.println(Arrays.toString(elements.toArray()));
        System.out.print(current);
    }
}
