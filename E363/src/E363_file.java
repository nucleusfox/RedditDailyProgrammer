/******************************************************************************
 *  Class: E363_file
 *  Author: nucleusfox
 *
 *  I before E except after C
 *  Reads the file "enable1.txt" with words and prints the number of words
 *  in the file that follow the english rule "I before E except after C".
 *
 *  Reddit DailyProgrammer - #363 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8q96da/20180611_challenge_363_easy_i_before_e_except/
 *
 *  Example:
 *  $ java E363_file
 *
 *  Result:
 *  Total exclusions = 2169
 ******************************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;

public class E363_file {
    static public void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("E363/enable1.txt"))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                if (!E363_word.checkSpelling(line)) {
                    //System.out.println(line);
                    counter++;
                }
            }
            System.out.println("Total exclusions = " + counter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("Bad filepath");
        }

    }
}