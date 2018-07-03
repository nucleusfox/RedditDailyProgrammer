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
    public static final HashMap<String, Integer> movableMajorDo = new HashMap<>();
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

        movableMajorDo.put("Do", 0);
        movableMajorDo.put("Di", 1);
        movableMajorDo.put("Ra", 1);
        movableMajorDo.put("Re", 2);
        movableMajorDo.put("Ri", 3);
        movableMajorDo.put("Me", 3);
        movableMajorDo.put("Ma", 3);
        movableMajorDo.put("Mi", 4);
        movableMajorDo.put("Fa", 5);
        movableMajorDo.put("Fi", 6);
        movableMajorDo.put("Se", 6);
        movableMajorDo.put("Sol", 7);
        movableMajorDo.put("Si", 8);
        movableMajorDo.put("Le", 8);
        movableMajorDo.put("Lo", 8);
        movableMajorDo.put("La", 9);
        movableMajorDo.put("Li", 10);
        movableMajorDo.put("Te", 10);
        movableMajorDo.put("Ta", 10);
        movableMajorDo.put("Ti", 11);
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
            System.out.println(chromaticScale[shift(chromaticScaleTone.get(notes[0]), movableMajorDo.get(notes[1]))]);
            line = sc.nextLine();
        }
    }
}
