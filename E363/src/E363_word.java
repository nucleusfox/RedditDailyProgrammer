/******************************************************************************
 *  Class: E363_word
 *  Author: nucleusfox
 *
 *  I before E except after C
 *  Accepts word and prints if it follows the english rule "I before E except
 *  after C".
 *
 *  Reddit DailyProgrammer - #363 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8q96da/20180611_challenge_363_easy_i_before_e_except/
 *
 *  Example:
 *  $ java E363_word
 *  fiery
 *
 *  Result:
 *  true
 *
 *  $ java E363_word
 *  ceiling
 *
 *  Result:
 *  true
 *
 *  $ java E363_word
 *  ancient
 *
 *  Result:
 *  false
 ******************************************************************************/

import java.util.Scanner;

public class E363_word {
    static public boolean checkSpelling(String word) {
        if (word.startsWith("ei")) return false;

        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (sb.length() == 0) sb.append(c);
            else if (sb.toString().equals("c") && c == 'i') sb.append(c);
            else if (sb.toString().equals("ci") && c == 'e')
                return false;

            else if (c == 'e' && sb.length() == 1 && !sb.toString().equals("c")) sb.append(c);
            else if (c == 'e' && sb.length() == 2) {
                sb.delete(0, 1);
                sb.append(c);
            } else if (c == 'i' && sb.length() == 2)
                return false;
            else {
                sb.delete(0, sb.length());
                sb.append(c);
            }
        }
        return true;
    }

    static public void main(String[] args) {
        System.out.println(checkSpelling(new Scanner(System.in).nextLine()));
    }
}