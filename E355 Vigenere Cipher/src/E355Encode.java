/******************************************************************************
 *  Class: E355Encode
 *  Author: nucleusfox
 *
 *  Vigenere Cipher - Encode
 *  Accepts lines with two words separated by a space, where the first is a secret
 *  word and the second is a plain text with spaces removed and in low case.
 *  Prints Vigenere-encoded cipher text on the input.
 *
 *  Reddit DailyProgrammer - #355 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/879u8b/20180326_challenge_355_easy_alphabet_cipher/
 *
 *  Example:
 *  $ java E355Encode
 *  snitch thepackagehasbeendelivered
 *
 *  Result:
 *  lumicjcnoxjhkomxpkwyqogywq
 ******************************************************************************/
import java.util.Scanner;

public class E355Encode {
    public static final int ALPHABET_LENGTH = 26;
    private static final int CHAR_FIRST = 97;

    public static char encode(char text, char code) {
        char cipher = (char) (((int) text + (int) code - 2 * CHAR_FIRST));
        if ((CHAR_FIRST + ALPHABET_LENGTH) - (int) text < (int) code)
            cipher = (char) ((int) cipher - ALPHABET_LENGTH + CHAR_FIRST);
        if ((int) cipher < CHAR_FIRST)
            cipher = (char) ((int) cipher + ALPHABET_LENGTH);
        return cipher;
    }

    public static String encode(String text, String code) {
        int i = 0;
        StringBuilder cipher = new StringBuilder();
        for (char t : text.toCharArray()) {
            cipher.append(encode(t, code.charAt(i)));
            i = i == code.length() - 1 ? 0 : i + 1;
        }
        return cipher.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.isEmpty()) {
            String[] words = input.toLowerCase().split("\\s+");

            System.out.println(encode(words[1], words[0]));
            input = sc.nextLine();
        }
    }
}