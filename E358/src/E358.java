/******************************************************************************
 *  Class: E358
 *  Author: nucleusfox
 *
 *  Decipher The Seven Segments
 *  Accepts 3 lines with digits drew in ink display style. Prints digits drew.
 *
 *
 *  Reddit DailyProgrammer - #358 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8eger3/20180423_challenge_358_easy_decipher_the_seven/
 *
 *  Example:
 *  $ java E358
 *      _  _     _  _  _  _  _
 *    | _| _||_||_ |_   ||_||_|
 *    ||_  _|  | _||_|  ||_| _|
 *
 *  Result:
 *  123456789
 *
 *  Example:
 *  $ java E358
 *      _  _  _  _  _  _  _  _
 *  |_| _| _||_|| ||_ |_| _||_
 *    | _| _||_||_| _||_||_  _|
 *
 *  Result:
 *  433805825
 ******************************************************************************/

import java.util.Scanner;

public class E358 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line1 = s.nextLine();
        String line2 = s.nextLine();
        String line3 = s.nextLine();

        for (int i = 0; i < Math.max(line1.length(), Math.max(line2.length(), line3.length())); i+=3) {
            if (line1.substring(i, i+3).equals("   ")
                    && line2.substring(i, i+3).equals("  |")
                    && line3.substring(i, i+3).equals("  |") ) System.out.print(1);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals(" _|")
                    && line3.substring(i, i+3).equals("|_ ") ) System.out.print(2);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals(" _|")
                    && line3.substring(i, i+3).equals(" _|") ) System.out.print(3);
            else if (line1.substring(i, i+3).equals("   ")
                    && line2.substring(i, i+3).equals("|_|")
                    && line3.substring(i, i+3).equals("  |") ) System.out.print(4);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals("|_ ")
                    && line3.substring(i, i+3).equals(" _|") ) System.out.print(5);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals("|_ ")
                    && line3.substring(i, i+3).equals("|_|") ) System.out.print(6);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals("  |")
                    && line3.substring(i, i+3).equals("  |") ) System.out.print(7);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals("|_|")
                    && line3.substring(i, i+3).equals("|_|") ) System.out.print(8);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals("|_|")
                    && line3.substring(i, i+3).equals(" _|") ) System.out.print(9);
            else if (line1.substring(i, i+3).equals(" _ ")
                    && line2.substring(i, i+3).equals("| |")
                    && line3.substring(i, i+3).equals("|_|") ) System.out.print(0);
        }
    }
}
