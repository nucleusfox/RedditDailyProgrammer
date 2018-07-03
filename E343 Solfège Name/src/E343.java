/******************************************************************************
 *  Class: E343
 *  Author: nucleusfox
 *
 *  Major scales
 *  Accepts note N and movable do solfège name M. Prints the note M in N scale.
 *
 *
 *  Reddit DailyProgrammer - #343 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/7hhyin/20171204_challenge_343_easy_major_scales/
 *
 *  Example:
 *  $ java E343
 *  C Do
 *
 *  Result:
 *  C
 *
 *  $ java E343
 *  A# Fa
 *
 *  Result:
 *  D#
 *
 *  $ java E343
 *  A# Sol
 *
 *  Result:
 *  F
 ******************************************************************************/
import java.util.HashMap;
import java.util.Scanner;

public class E343 {
    public static final String[] chromaticScale = new String[]
            {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public static final HashMap<String, Integer> chromaticScaleTone = new HashMap<>();
    public static final HashMap<String, Integer> movableDo = new HashMap<>();
    static
    {
        chromaticScaleTone.put("C", 0);
        chromaticScaleTone.put("C#", 1);
        chromaticScaleTone.put("D", 2);
        chromaticScaleTone.put("D#", 3);
        chromaticScaleTone.put("E", 4);
        chromaticScaleTone.put("F", 5);
        chromaticScaleTone.put("F#", 6);
        chromaticScaleTone.put("G", 7);
        chromaticScaleTone.put("G#", 8);
        chromaticScaleTone.put("A", 9);
        chromaticScaleTone.put("A#", 10);
        chromaticScaleTone.put("B", 11);

        movableDo.put("Do", 0);
        movableDo.put("Di", 1);
        movableDo.put("Ra", 1);
        movableDo.put("Re", 2);
        movableDo.put("Ri", 3);
        movableDo.put("Me", 3);
        movableDo.put("Ma", 3);
        movableDo.put("Mi", 4);
        movableDo.put("Fa", 5);
        movableDo.put("Fi", 6);
        movableDo.put("Se", 6);
        movableDo.put("Sol", 7);
        movableDo.put("Si", 8);
        movableDo.put("Le", 8);
        movableDo.put("Lo", 8);
        movableDo.put("La", 9);
        movableDo.put("Li", 10);
        movableDo.put("Te", 10);
        movableDo.put("Ta", 10);
        movableDo.put("Ti", 11);
    }

    public static int shift(int current, int shift) {
        int shifted = current + shift;
        if (shifted > 12) shifted -= 12;
        return shifted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (!line.isEmpty()) {
            String[] notes = line.split("\\s+");
            System.out.println(chromaticScale[shift(chromaticScaleTone.get(notes[0]), movableDo.get(notes[1]))]);
            line = sc.nextLine();
        }
    }
}
