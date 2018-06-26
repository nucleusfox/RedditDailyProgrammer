/******************************************************************************
 *  Class: E355Decode
 *  Author: nucleusfox
 *
 *  Vigenere Cipher - Decode
 *  Accepts lines with two words separated by a space, where the first is a secret
 *  word and the second is a cipher text.
 *  Prints Vigenere-decoded plain text with spaces removed and in low case.
 *
 *  Reddit DailyProgrammer - #355 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/879u8b/20180326_challenge_355_easy_alphabet_cipher/
 *
 *  Example:
 *  $ java E355Decode
 *  snitch lumicjcnoxjhkomxpkwyqogywq
 *
 *  Result:
 *  thepackagehasbeendelivered
 ******************************************************************************/
import java.util.Scanner;

public class E355Decode {
    public static final int ALPHABET_LENGTH = 26;
    private static final int CHAR_FIRST = 97;

    public static char decode(char cipher, char code) {
        char text;
        if ((int) cipher < (int) code)
            text = (char) (((int) cipher - (int) code) + ALPHABET_LENGTH + CHAR_FIRST);
        else text = (char) (((int) cipher - (int) code) + CHAR_FIRST);
        return text;
    }

    public static String decode(String cipher, String code) {
        int i = 0;
        StringBuilder text = new StringBuilder();
        for (char t : cipher.toCharArray()) {
            text.append(decode(t, code.charAt(i)));
            i = i == code.length() - 1 ? 0 : i + 1;
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.isEmpty()) {
            String[] words = input.toLowerCase().split("\\s+");

            System.out.println(decode(words[1], words[0]));
            input = sc.nextLine();
        }
    }
}